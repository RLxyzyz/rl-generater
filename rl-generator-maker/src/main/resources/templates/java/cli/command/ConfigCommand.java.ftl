package ${basePackage}.cli.command;

import cn.hutool.core.util.ReflectUtil;
import ${basePackage}.model.DataModel;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
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
