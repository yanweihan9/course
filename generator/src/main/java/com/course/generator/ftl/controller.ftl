package com.course.${module}.controller.admin;

import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.dto.${Domain}Dto;
import com.course.server.service.${Domain}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @author Administrator
*/
@RestController
@RequestMapping("/admin/${domain}")
@Slf4j
public class ${Domain}Controller {

@Resource
private ${Domain}Service ${domain}Service;

public static final String BUSINESS_NAME = "${tableNameCn}";

/**
* 列表
*
* @param pageDto
* @return
*/
@PostMapping("/list")
public ResponseDto list(@RequestBody PageDto pageDto) {
ResponseDto responseDto = new ResponseDto();
responseDto.setContent(${domain}Service.list(pageDto));
return responseDto;
}

/**
* 保存
*
* @param ${domain}Dto
* @return
*/
@PostMapping("/save")
public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto) {
ResponseDto responseDto = new ResponseDto();
responseDto.setContent(${domain}Service.save(${domain}Dto));
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
responseDto.setContent(${domain}Service.delete(id));
return responseDto;
}
}
