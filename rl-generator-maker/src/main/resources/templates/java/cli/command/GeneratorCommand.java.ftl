package ${basePackage}.maker.cli.command;

import lombok.Data;
import ${basePackage}.maker.MainGenerator;
import ${basePackage}.maker.cli.generate.file.DynamicFileGenerator;
import ${basePackage}.maker.model.DataModel;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

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
     /**
     * ${modelInfo.author}
     * */
    @Option(names = {"${model.abbr}", "--author"}, description = "${model.description}", required = true,arity = "0..1",interactive = true,echo = true)
    private ${mode.type} ${model.name} <#if model.defaultValue??>= ${model.defaultValue?c}</#if>;
</#list>
    @Override public Object call() throws Exception {
        DataModel config=new DataModel();
        BeanUtil.copyProperties(this,config);
        MainGenerator.doGenerate(config);
        return 0;
    }
}
