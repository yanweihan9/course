package com.course.business.controller.admin;

import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.dto.SectionDto;
import com.course.server.dto.SectionPageDto;
import com.course.server.service.SectionService;
import lombok.extern.slf4j.Slf4j;
import com.course.server.utils.ValidatorUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/admin/section")
@Slf4j
public class SectionController {

    @Resource
    private SectionService sectionService;

    public static final String BUSINESS_NAME = "小节";

    /**
     * 列表
     *
     * @param sectionPageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody SectionPageDto sectionPageDto) {
        ResponseDto responseDto = new ResponseDto();
        ValidatorUtil.require(sectionPageDto.getCourseId(), "课程ID");
        ValidatorUtil.require(sectionPageDto.getChapterId(), "大章ID");
        responseDto.setContent(sectionService.list(sectionPageDto));
        return responseDto;
    }

    /**
     * 保存
     *
     * @param sectionDto
     * @return
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto) {
        //保存校验
        ValidatorUtil.require(sectionDto.getTitle(), "标题");
        ValidatorUtil.length(sectionDto.getTitle(), "标题", 1, 50);
        ValidatorUtil.length(sectionDto.getVideo(), "视频", 1, 200);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(sectionService.save(sectionDto));
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
        responseDto.setContent(sectionService.delete(id));
        return responseDto;
    }
}
