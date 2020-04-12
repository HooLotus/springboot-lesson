package com.example.mybatisannotationdemo.params;

import lombok.Data;

/**
 * @author WU, Homer
 * @version 1.0
 * @description
 */
@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;
    public int getBeginLine(){
        return pageSize * currentPage;
    }
}
