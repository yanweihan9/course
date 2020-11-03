package com.course.generator.server;

import com.course.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 颜伟晗
 * @since 2020/11/3
 */
public class ServerGenerator {

    public static final String toServivePath = "server\\src\\main\\java\\com\\course\\server\\service\\";


    public static void main(String[] args) throws IOException, TemplateException {
        String Domain = "Section";
        String domain = "section";
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServivePath + Domain + "Service.java", map);
    }
}
