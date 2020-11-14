package com.course.server.service;

import com.course.server.domain.${Domain};
import com.course.server.domain.${Domain}Example;
import com.course.server.dto.${Domain}Dto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.${Domain}Mapper;
import com.course.server.utils.CollectionUtils;
import com.course.server.utils.CopyUtil;
import com.course.server.utils.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
<#list typeSet as type>
    <#if type=='Date'>
import java.util.Date;
    </#if>
</#list>

@Service
public class ${Domain}Service {

    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    /**
     * 列表
     *
     * @param page
     * @return
     */
    public PageDto<${Domain}Dto> list(PageDto<${Domain}Dto> page) {
        PageHelper.startPage(page.getPage(), page.getSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        <#list fieldList as field>
            <#if field.nameHump=='sort'>
        ${domain}Example.setOrderByClause("sort asc");
            </#if>
        </#list>
        List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}List);
        page.setTotal(pageInfo.getTotal());
        List<${Domain}Dto> ${domain}DtoList = CollectionUtils.convert(${domain}List, ${Domain}Dto.class);
        page.setList(${domain}DtoList);
        return page;
    }

    /**
     * 保存
     *
     * @param ${domain}Dto
     * @return
     */
    public ${Domain}Dto save(${Domain}Dto ${domain}Dto) {
        if (StringUtils.isEmpty(${domain}Dto.getId())) {
            insert(${domain}Dto);
            return ${domain}Dto;
        }
        update(${domain}Dto);
        return ${domain}Dto;
    }

    private ${Domain}Dto insert(${Domain}Dto ${domain}Dto) {
        ${domain}Dto.setId(UuidUtil.getShortUuid());
        ${Domain} ${domain} = CopyUtil.copy(${domain}Dto, ${Domain}.class);
        Date now = new Date();
        <#list fieldList as field>
            <#if field.nameHump=='createdAt'>
        ${domain}.setCreatedAt(now);
            </#if>
            <#if field.nameHump=='updatedAt'>
        ${domain}.setUpdatedAt(now);
            </#if>
        </#list>
        ${domain}Mapper.insert(${domain});
        return ${domain}Dto;
    }

    private ${Domain}Dto update(${Domain}Dto ${domain}Dto) {
        ${Domain} ${domain} = CopyUtil.copy(${domain}Dto, ${Domain}.class);
        Date now = new Date();
        <#list fieldList as field>
            <#if field.nameHump=='updatedAt'>
        ${domain}.setUpdatedAt(now);
            </#if>
        </#list>
        ${domain}Mapper.updateByPrimaryKey(${domain});
        return ${domain}Dto;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public Integer delete(String id) {
        return ${domain}Mapper.deleteByPrimaryKey(id);
    }
}
