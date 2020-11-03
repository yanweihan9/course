package com.course.business.controller.admin;

import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.dto.SectionDto;
import com.course.server.service.SectionService;
import lombok.extern.slf4j.Slf4j;
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
     * @param pageDto
     * @return
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(sectionService.list(pageDto));
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
