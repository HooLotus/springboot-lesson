package com.example.mybatisannotationdemo.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author WU, Homer
 * @version 1.0
 * @description
 */
@Data
@Builder
public class Message {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
