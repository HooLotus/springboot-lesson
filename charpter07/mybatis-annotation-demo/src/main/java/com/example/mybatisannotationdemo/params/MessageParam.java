package com.example.mybatisannotationdemo.params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WU, Homer
 * @version 1.0
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageParam extends PageParam{
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
