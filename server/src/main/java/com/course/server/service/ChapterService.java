package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.ChapterPageDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
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
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    /**
     * 列表
     *
     * @param chapterPageDto
     * @return
     */
    public PageDto<ChapterDto> list(ChapterPageDto chapterPageDto) {
        PageHelper.startPage(chapterPageDto.getPage(), chapterPageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();
        if (!StringUtils.isEmpty(chapterPageDto.getCourseId())) {
            criteria.andCourseIdEqualTo(chapterPageDto.getCourseId());
        }
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        chapterPageDto.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtoList = CollectionUtils.convert(chapterList, ChapterDto.class);
        chapterPageDto.setList(chapterDtoList);
        return chapterPageDto;
    }

    /**
     * 保存
     *
     * @param chapterDto
     * @return
     */
    public ChapterDto save(ChapterDto chapterDto) {

        if (StringUtils.isEmpty(chapterDto.getId())) {
            insert(chapterDto);
            return chapterDto;
        }
        update(chapterDto);
        return chapterDto;
    }

    private ChapterDto insert(ChapterDto chapterDto) {
        chapterDto.setId(UuidUtil.getShortUuid());
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        chapterMapper.insert(chapter);
        return chapterDto;
    }

    private ChapterDto update(ChapterDto chapterDto) {
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        chapterMapper.updateByPrimaryKey(chapter);
        return chapterDto;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public Integer delete(String id) {
        return chapterMapper.deleteByPrimaryKey(id);
    }
}
