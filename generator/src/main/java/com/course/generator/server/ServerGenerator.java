package com.course.generator.server;

import com.course.generator.util.DbUtil;
import com.course.generator.util.Field;
import com.course.generator.util.FreemarkerUtil;

import java.util.*;

/**
 * @author 颜伟晗
 * @since 2020/11/3
 */
public class ServerGenerator {

    public static final String MODULE = "business";

    private static final String toServivePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    private static final String toDtoPath = "server\\src\\main\\java\\com\\course\\server\\dto\\";
    private static final String toControllerPath = MODULE + "\\src\\main\\java\\com\\course\\" + MODULE + "\\controller\\admin\\";


    public static void main(String[] args) throws Exception {
        String Domain = "Section";
        String domain = "section";
        String tableNameCn = "小节";
        String module = MODULE;
        List<Field> fieldList = DbUtil.getColumnByTableName(domain);
        Set<String> typeSet = getJaveTypes(fieldList);
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        map.put("tableNameCn", tableNameCn);
        map.put("module", module);
        map.put("fieldList", fieldList);
        map.put("typeSet", typeSet);
        //生成dto
        FreemarkerUtil.initConfig("dto.ftl");
        FreemarkerUtil.generator(toDtoPath + Domain + "Dto.java", map);
        //生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServivePath + Domain + "Service.java", map);
        //生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Domain + "Controller.java", map);
    }

    /**
     * 获取所有的java类型，使用set去重
     *
     * @param fieldList
     * @return
     */
    private static Set<String> getJaveTypes(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }
        return set;
    }
}
