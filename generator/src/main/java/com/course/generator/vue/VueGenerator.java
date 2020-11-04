package com.course.generator.vue;

import com.course.generator.util.DbUtil;
import com.course.generator.util.Field;
import com.course.generator.util.FreemarkerUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * @author 颜伟晗
 * @since 2020/11/3
 */
public class VueGenerator {

    public static final String MODULE = "business";

    private static final String toVuePath = "admin\\src\\views\\admin\\";
    private static final String generatorConfigPath = "server\\src\\main\\resources\\generator\\generatorConfig.xml";


    public static void main(String[] args) throws Exception {
        File file = new File(generatorConfigPath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        //获取xml根节点
        Element rootElement = doc.getRootElement();
        //读取context节点
        Element contextElement = rootElement.element("context");
        //定义一个Element用于遍历
        Element tableElement;
        //取第一个"table"节点
        tableElement = contextElement.elementIterator("table").next();
        String Domain = tableElement.attributeValue("domainObjectName");
        String tableName = tableElement.attributeValue("tableName");
        String tableNameCn = DbUtil.getTableComment(tableName);
        String domain = Domain.substring(0, 1).toLowerCase() + Domain.substring(1);
        System.out.println("表：" + tableName);
        System.out.println("Domian:" + Domain);
        String module = MODULE;
        List<Field> fieldList = DbUtil.getColumnByTableName(tableName);
        Set<String> typeSet = getJaveTypes(fieldList);
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        map.put("tableNameCn", tableNameCn);
        map.put("module", module);
        map.put("fieldList", fieldList);
        map.put("typeSet", typeSet);
        //生成vue
        FreemarkerUtil.initConfig("vue.ftl");
        FreemarkerUtil.generator(toVuePath + domain + ".vue", map);

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
