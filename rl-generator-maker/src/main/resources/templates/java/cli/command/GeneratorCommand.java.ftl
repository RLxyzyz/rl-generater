package ${basePackage}.cli.command;

import lombok.Data;
import ${basePackage}.cli.generator.MainGenerator;
import ${basePackage}.cli.generator.DynamicGenerator;
import ${basePackage}.model.DataModel;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import cn.hutool.core.bean.BeanUtil;
import java.util.concurrent.Callable;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
 */
@Command(name="generator", mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable {
<#list modelConfig.models as model>
    <#if model.description??>
     /**
     * ${model.description}
     * */
     </#if>
    @Option(names = {"${model.abbr}"}, description = "${model.description}", required = true,arity = "0..1",interactive = true,echo = true)
    private ${model.type} ${model.name} <#if model.defaultValue??>= ${model.defaultValue?c}</#if>;
</#list>
    @Override public Object call() throws Exception {
        DataModel config=new DataModel();
        BeanUtil.copyProperties(this,config);
        MainGenerator.doGenerate(config);
        return 0;
    }
}
