package com.course.server.dto;

import lombok.Data;

/**
 * @author 颜伟晗
 * @since 2020/10/30
 */
@Data
public class ResponseDto<T> {

    private boolean success = true;
    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回泛型数据
     */
    private T content;
}
