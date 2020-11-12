package com.course.business.controller.admin;

import com.course.server.dto.ChapterPageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.dto.ChapterDto;
import com.course.server.service.ChapterService;
import com.course.server.utils.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/admin/chapter")
@Slf4j
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    public static final String BUSINESS_NAME = "大章";

    /**
     * 列表
     *
     * @param chapterPageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody ChapterPageDto chapterPageDto) {
        ResponseDto responseDto = new ResponseDto();
        ValidatorUtil.require(chapterPageDto.getCourseId(),"课程ID");
        responseDto.setContent(chapterService.list(chapterPageDto));
        return responseDto;
    }

    /**
     * 保存
     *
     * @param chapterDto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(chapterService.save(chapterDto));
        return responseDto;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable("id") String id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(chapterService.delete(id));
        return responseDto;
    }
}
