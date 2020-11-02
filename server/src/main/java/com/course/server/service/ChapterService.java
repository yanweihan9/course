package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
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
     * @param page
     * @return
     */
    public PageDto<ChapterDto> list(PageDto<ChapterDto> page) {
        PageHelper.startPage(page.getPage(), page.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        page.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtoList = CollectionUtils.convert(chapterList, ChapterDto.class);
        page.setList(chapterDtoList);
        return page;
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
