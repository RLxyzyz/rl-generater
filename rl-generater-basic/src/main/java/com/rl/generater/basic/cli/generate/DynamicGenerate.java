package com.rl.generater.basic.cli.generate;

import cn.hutool.core.date.DateTime;
import com.rl.generater.basic.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 动态模板
 * @date 2024/11/15 21:24:15
 */
public class DynamicGenerate {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg=new Configuration(Configuration.VERSION_2_3_33);
        String projectPath = System.getProperty("user.dir");
        String parentPath = projectPath + File.separator+"rl-generater-basic";
        cfg.setDirectoryForTemplateLoading(new File(parentPath,"src/main/resources/template"));
        cfg.setDefaultEncoding("UTF-8");

        //设置模型
        MainTemplateConfig config=new MainTemplateConfig();
        config.setAuthor("任磊");
        config.setOutput("12222::");
        config.setLoop(true);

        //组装
        Writer out= new FileWriter("MainTemplate.java");
        cfg.getTemplate("mainTemplate.ftl").process(config,out);
    }

    /**
     * 模板生成
     * @param inputPath 模板路径
     * @param outputPath 输出路径
     * @param model 模板数据
     */
    public static void doGenerator(String inputPath,String outputPath,Object model)
        throws IOException, TemplateException {
        Configuration cfg=new Configuration(Configuration.VERSION_2_3_33);
        String projectPath = System.getProperty("user.dir");
        String parentPath = projectPath + File.separator+"rl-generater-basic";
        System.out.println(inputPath);
        File templateFile=new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateFile);
        cfg.setDefaultEncoding("UTF-8");

        //组装
        Writer out= new FileWriter(outputPath);
        cfg.getTemplate("mainTemplate.ftl").process(model,out);
    }
}
