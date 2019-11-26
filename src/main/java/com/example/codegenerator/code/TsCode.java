package com.example.codegenerator.code;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

public class TsCode {
    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);

    public static void main(String[] args) {
        generator();
    }

    private static void generator() {
        try {
            configuration.setDirectoryForTemplateLoading(new File("config").getAbsoluteFile());

            Template template = configuration.getTemplate("Bean.ftl");

            HashMap<String, Serializable> hashMap = GetExcel.getData();

//            hashMap.put("className", "Bean");
//
//            ArrayList<String> arrayList = new ArrayList<>();
//            arrayList.add("field1");
//            arrayList.add("field2");
//            arrayList.add("field3");
//            arrayList.add("field4");
//
//            hashMap.put("fields", arrayList);

            Writer out = new FileWriter("codeOut/bean.ts");



            template.process(hashMap, out);

            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
