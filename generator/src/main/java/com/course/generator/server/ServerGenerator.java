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

    public static final String MODULE = "business";

    private static final String toServivePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    private static final String toControllerPath = MODULE + "\\src\\main\\java\\com\\course\\" + MODULE + "\\controller\\admin\\";


    public static void main(String[] args) throws IOException, TemplateException {
        String Domain = "Section";
        String domain = "section";
        String tableNameCn = "小节";
        String module = MODULE;
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        map.put("tableNameCn", tableNameCn);
        map.put("module", module);
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServivePath + Domain + "Service.java", map);
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Domain + "Controller.java", map);
    }
}
