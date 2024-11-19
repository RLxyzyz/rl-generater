package ${basePackage}.generater.maker.cli.generate;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
 */
public class MainGenerator {

    public void doGenerate(Object model) throws TemplateException, IOException {
        String inputRootPath = "${inputRootPath}";
        String outputRootPath = "${outputRootPath}";
<#list fileConfig.files as file>
    <#if file.generateType=="static">
        //静态文件
        String inputPath = new File(inputRootPath, "${file.inputPath}").getAbsolutePath();
        String outputPath = new File(outputRootPath, "${file.outputPath}").getAbsolutePath();
        StaticGenerate.copyFile(inputPath, outputPath, model);
    <#else >
        //动态文件
        String inputPath = new File(inputRootPath, "${file.inputPath}").getAbsolutePath();
        String outputPath = new File(outputRootPath, "${file.outputPath}").getAbsolutePath();
        DynamicGenerate.doGenerator(inputPath, outputPath, model);
    </#if>
</#list>

    }
}
