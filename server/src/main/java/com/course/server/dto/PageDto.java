package com.course.server.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 颜伟晗
 * @since 2020/10/30
 */
@Data
public class PageDto<T> {

    /**
     * 当前页码
     */
    private int page;
    /**
     * 每页条数
     */
    private int size;
    /**
     * 总条数
     */
    private long total;
    /**
     * 集合
     */
    private List<T> list;

    public PageDto() {
    }

    public PageDto(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
