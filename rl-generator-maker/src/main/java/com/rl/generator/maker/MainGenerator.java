package com.rl.generator.maker;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.rl.generator.maker.cli.generate.file.DynamicFileGenerator;
import com.rl.generator.maker.meta.Meta;
import com.rl.generator.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description测试
 * @date 2024/11/17 16:32:02
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //获取元信息
        Meta meta = MetaManager.newInstance();
        //项目根路径
        String projectPath = System.getProperty("user.dir");
        //输出路径
        String outputPath = projectPath + File.separator + "generated";
        if (!FileUtil.exist(outputPath)){
            FileUtil.mkdir(outputPath);
        }
        //获取resource路径
        ClassPathResource classPathResource= new ClassPathResource("templates/java/model/DataModel.java.ftl");
        String resourcePath = classPathResource.getAbsolutePath();
        if (!FileUtil.exist(resourcePath)){
            System.out.println("模板文件不存在");
        }
        //模板文件路径
        String templatePath = resourcePath;
        String basePackage = StringUtils.join(StrUtil.split(meta.getBasePackage(), "."), File.separator);
        String outputBasePath = outputPath + File.separator +"src/main/java" + File.separator + basePackage;
        String outputFilePath = outputBasePath + File.separator + "DataModel.java";
        DynamicFileGenerator.doGenerator(templatePath,outputFilePath,meta);

        DynamicFileGenerator.doGenerator(templatePath,outputFilePath,meta);
    }
}
