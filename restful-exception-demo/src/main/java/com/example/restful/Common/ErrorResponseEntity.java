package com.example.restful.Common;

import lombok.*;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/26
 * @description : 通用返回值类,统一数据响应的返回结果格式
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;
}
