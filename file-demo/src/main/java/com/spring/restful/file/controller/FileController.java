package com.spring.restful.file.controller;

import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.springframework.util.StringUtils.getFilename;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/31 8:46
 * @description:
 */
@RestController
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(MultipartFile file, HttpServletRequest request) {
        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/"));
        String realPath = request.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //修改文件名
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        try {
            //保存文件
            file.transferTo(new File(folder, newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/img" + format + newName;
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            e.printStackTrace();
            // throw new CustomException(ExceptionType.OTHER_ERROR.getCode(), e.getMessage());
        }
        return null;
    }


    @Value("${file.download.root.dir}")
    private String dirPath;

    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> fileDownload(@PathVariable String filename,
                                               HttpServletRequest request) {
        java.io.File file = new java.io.File(dirPath, filename);
        if (!file.exists()) {
            try {
                filename = getFilename(request, filename);

                // 设置响应头
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");
                headers.add("Last-Midified", new Data().toString());
                headers.setContentDispositionFormData("attachment", filename);
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .contentLength(file.length())
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(new FileSystemResource(file));
            } catch (Exception e) {
                e.printStackTrace();
                //throw new CustomException(ExceptionType.OTHER_ERROR.getCode(), e.getMessage());
            }
        }
        return null;
    }

    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename (HttpServletRequest request, String filename){
        // IE不同版本User-Agent中出现的关键词
        String[] ieBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : ieBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                // IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        // 其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }
}

