package com.course.server.dto;

import lombok.Data;

/**
 * @author 颜伟晗
 * @since 2020/11/12
 */
@Data
public class SectionPageDto extends PageDto {
    private String chapterId;
    private String courseId;
}
