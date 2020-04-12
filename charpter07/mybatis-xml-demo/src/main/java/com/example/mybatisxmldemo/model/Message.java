package com.example.mybatisxmldemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WU, Homer
 * @version 1.0
 * @description
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
