package com.course.server.service;

import com.course.server.domain.Section;
import com.course.server.domain.SectionExample;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.SectionPageDto;
import com.course.server.enums.CourseChargeEnum;
import com.course.server.mapper.SectionMapper;
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
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;
    @Resource
    private CourseService courseService;

    /**
     * 列表
     *
     * @param sectionPageDto
     * @return
     */
    public PageDto<SectionDto> list(SectionPageDto sectionPageDto) {
        PageHelper.startPage(sectionPageDto.getPage(), sectionPageDto.getSize());
        SectionExample sectionExample = new SectionExample();
        sectionExample.setOrderByClause("sort asc");
        SectionExample.Criteria criteria = sectionExample.createCriteria();
        if (!StringUtils.isEmpty(sectionPageDto.getChapterId())) {
            criteria.andChapterIdEqualTo(sectionPageDto.getChapterId());
        }
        if (!StringUtils.isEmpty(sectionPageDto.getCourseId())) {
            criteria.andCourseIdEqualTo(sectionPageDto.getCourseId());
        }
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        sectionPageDto.setTotal(pageInfo.getTotal());
        List<SectionDto> sectionDtoList = CollectionUtils.convert(sectionList, SectionDto.class);
        sectionPageDto.setList(sectionDtoList);
        return sectionPageDto;
    }

    /**
     * 保存
     *
     * @param sectionDto
     * @return
     */
    public SectionDto save(SectionDto sectionDto) {
        if (StringUtils.isEmpty(sectionDto.getId())) {
            insert(sectionDto);
            return sectionDto;
        }
        update(sectionDto);
        courseService.updateTime(sectionDto.getCourseId());
        return sectionDto;
    }

    private SectionDto insert(SectionDto sectionDto) {
        sectionDto.setId(UuidUtil.getShortUuid());
        Section section = CopyUtil.copy(sectionDto, Section.class);
        Date now = new Date();
        section.setCreatedAt(now);
        section.setUpdatedAt(now);
        section.setCharge(CourseChargeEnum.CHARGE.getCode());
        sectionMapper.insert(section);
        return sectionDto;
    }

    private SectionDto update(SectionDto sectionDto) {
        Section section = CopyUtil.copy(sectionDto, Section.class);
        Date now = new Date();
        section.setUpdatedAt(now);
        sectionMapper.updateByPrimaryKey(section);
        return sectionDto;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public Integer delete(String id) {
        return sectionMapper.deleteByPrimaryKey(id);
    }
}
