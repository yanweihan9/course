package com.course.server.service;

import com.course.server.domain.Section;
import com.course.server.domain.SectionExample;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
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

@Service
public class SectionService {

@Resource
private SectionMapper sectionMapper;

    /**
* 列表
*
* @param page
* @return
     */
public PageDto
<SectionDto> list(PageDto
    <SectionDto> page) {
        PageHelper.startPage(page.getPage(), page.getSize());
        SectionExample sectionExample = new SectionExample();
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        page.setTotal(pageInfo.getTotal());
        List
        <SectionDto> sectionDtoList = CollectionUtils.convert(sectionList, SectionDto.class);
            page.setList(sectionDtoList);
            return page;
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
            return sectionDto;
            }

            private SectionDto insert(SectionDto sectionDto) {
            sectionDto.setId(UuidUtil.getShortUuid());
            Section section = CopyUtil.copy(sectionDto, Section.class);
            sectionMapper.insert(section);
            return sectionDto;
            }

            private SectionDto update(SectionDto sectionDto) {
            Section section = CopyUtil.copy(sectionDto, Section.class);
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