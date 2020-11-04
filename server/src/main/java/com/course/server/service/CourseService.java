package com.course.server.service;

import com.course.server.domain.Course;
import com.course.server.domain.CourseExample;
import com.course.server.dto.CourseDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.CourseMapper;
import com.course.server.utils.CollectionUtils;
import com.course.server.utils.CopyUtil;
import com.course.server.utils.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;

@Service
public class CourseService {

    @Resource
    private CourseMapper courseMapper;

    /**
     * 列表
     *
     * @param page
     * @return
     */
    public PageDto<CourseDto> list(PageDto <CourseDto> page) {
        PageHelper.startPage(page.getPage(), page.getSize());
        CourseExample courseExample = new CourseExample();
        courseExample.setOrderByClause("sort asc");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        page.setTotal(pageInfo.getTotal());
        List<CourseDto> courseDtoList = CollectionUtils.convert(courseList, CourseDto.class);
        page.setList(courseDtoList);
        return page;
    }

    /**
     * 保存
     *
     * @param courseDto
     * @return
     */
    public CourseDto save(CourseDto courseDto) {
        if (StringUtils.isEmpty(courseDto.getId())) {
            insert(courseDto);
            return courseDto;
        }
        update(courseDto);
        return courseDto;
    }

    private CourseDto insert(CourseDto courseDto) {
        courseDto.setId(UuidUtil.getShortUuid());
        Course course = CopyUtil.copy(courseDto, Course.class);
        Date now = new Date();
        course.setCreatedAt(now);
        course.setUpdatedAt(now);
        courseMapper.insert(course);
        return courseDto;
    }

    private CourseDto update(CourseDto courseDto) {
        Course course = CopyUtil.copy(courseDto, Course.class);
        Date now = new Date();
        course.setUpdatedAt(now);
        courseMapper.updateByPrimaryKey(course);
        return courseDto;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public Integer delete(String id) {
        return courseMapper.deleteByPrimaryKey(id);
    }
}
