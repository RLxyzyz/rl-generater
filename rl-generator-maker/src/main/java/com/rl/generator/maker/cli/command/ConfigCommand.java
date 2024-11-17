package com.rl.generator.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.rl.generator.maker.model.DataModel;
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
        Class<DataModel> configClass = DataModel.class;
        Field[] fields = ReflectUtil.getFields(configClass);
        for (Field field : fields) {
            System.out.println("字段名称"+field.getName());
            System.out.println("字段类型"+field.getType());
        }
    }
}
