package com.rl.generater.basic.cli.command;

import cn.hutool.core.util.ReferenceUtil;
import cn.hutool.core.util.ReflectUtil;
import com.rl.generater.basic.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description
 * @date 2024/11/16 13:40:21
 */
@Command(name = "config", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override public void run() {
        Class<MainTemplateConfig> configClass = MainTemplateConfig.class;
        Field[] fields = ReflectUtil.getFields(configClass);
        for (Field field : fields) {
            System.out.println("字段名称"+field.getName());
            System.out.println("字段类型"+field.getType());
        }
    }
}
