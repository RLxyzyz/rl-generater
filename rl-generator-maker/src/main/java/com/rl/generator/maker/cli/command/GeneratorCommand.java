package com.rl.generator.maker.cli.command;


import com.rl.generator.maker.model.DataModel;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description
 * @date 2024/11/16 13:40:07
 */
@Command(name="generator", mixinStandardHelpOptions = true)
public class GeneratorCommand implements Callable {

    /**
     * 作者
     * */
    @Option(names = {"-a", "--author"}, description = "作者", required = true,arity = "0..1",interactive = true,echo = true)
    private String author;

    /**
     * 输出
     * */
    @Option(names = {"-o", "--output"}, description = "输出", required = true,arity = "0..1",interactive = true,echo = true)
    private String output;

    /**
     * 是否循环
     * */
    @Option(names = {"-l", "--loop"}, description = "是否循环",required = true,arity = "0..1",interactive = true,echo = true)
    private boolean loop;
    @Override public Object call() throws Exception {
        DataModel config=new DataModel();
        config.setLoop(loop);
        config.setAuthor(author);
        config.setOutput(output);
        //BeanUtil.copyProperties(this,config);
        //MainGenerator.doGenerate(config);
        return 0;
    }
}
