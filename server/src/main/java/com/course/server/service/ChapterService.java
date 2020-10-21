package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.utils.CollectionUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public List<ChapterDto> list() {
        PageHelper.startPage(1,1);
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        return CollectionUtils.convert(chapterList, ChapterDto.class);
    }
}
