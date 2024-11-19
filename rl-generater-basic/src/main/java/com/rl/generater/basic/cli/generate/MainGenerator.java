package com.rl.generater.basic.cli.generate;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 主要的生成器（动态+静态）
 * @date 2024/11/16 18:47:51
 */
public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String inputRootPath = "D:\\workspace\\rl-generater\\rl-generator-maker\\src\\main\\resources\\template";
        String outputRootPath = "D:\\workspace\\rl-generater\\rl-generator-maker\\src\\main\\resources\\output";

        String inputPath = new File(inputRootPath, "mainTemplate.ftl").getAbsolutePath();
        String outputPath = new File(outputRootPath, "mainTemplate.java").getAbsolutePath();
        DynamicGenerate.doGenerator(inputPath, outputPath, model);

        //静态文件
        inputPath = new File(inputRootPath, "staticTemplate.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "staticTemplate.java").getAbsolutePath();
        StaticGenerate.copyFile(inputPath, outputPath, true);


        /*String projectPath = System.getProperty("user.dir");
        String parentPath = new File(projectPath).getParent();
        System.out.println("projectPath:"+projectPath);
        System.out.println("parentPath:"+parentPath);
        String inputPath = new File(projectPath,"demo/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        //复制文件
        StaticGenerate.copyFile(inputPath,outputPath,true);
        //动态生成
        String inputDynamicPath = projectPath+File.separator+"rl-generater-basic/src/main/resources/template/mainTemplate.ftl";
        String outputDynamicPath = projectPath+File.separator+"acm-template/src/com/acm/Main.java";
        DynamicGenerate.doGenerator(inputDynamicPath,outputDynamicPath,model);*/
    }
}
