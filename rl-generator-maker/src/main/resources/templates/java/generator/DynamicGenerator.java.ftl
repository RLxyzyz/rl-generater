package ${basePackage}.generator.maker.cli.generate.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
 */
public class DynamicGenerator {


    /**
     * ${description}
     * @param inputPath 模板路径
     * @param outputPath 输出路径
     * @param model 模板数据
     */
    public static void doGenerator(String inputPath,String outputPath,Object model)throws IOException, TemplateException {
        Configuration cfg=new Configuration(Configuration.VERSION_2_3_33);
        File templateFile=new File(inputPath);
        cfg.setDirectoryForTemplateLoading(templateFile.getParentFile());
        cfg.setDefaultEncoding("UTF-8");
        //组装
        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }
        Writer out= new FileWriter(outputPath);
        cfg.getTemplate(templateFile.getName()).process(model,out);
    }
}
