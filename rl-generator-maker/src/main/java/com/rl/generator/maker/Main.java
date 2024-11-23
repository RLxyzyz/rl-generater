package com.rl.generator.maker;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.rl.generator.maker.cli.generate.MainGenerator;
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
public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
