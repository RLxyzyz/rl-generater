package com.rl.generater.basic.cli;

import com.rl.generater.basic.cli.command.ConfigCommand;
import com.rl.generater.basic.cli.command.GeneratorCommand;
import com.rl.generater.basic.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 命令执行器
 * @date 2024/11/16 13:41:27
 */
@Command(name="rl",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this);
        commandLine.addSubcommand(new ListCommand());
        commandLine.addSubcommand(new ConfigCommand());
        commandLine.addSubcommand(new GeneratorCommand());
    }

    @Override public void run() {
        //不输入子命令时，给予提示
        System.out.println("请输入子命令，或使用--help命令查看提示");
    }

    /**
     * 执行命令
     * */
    public int execute(String[] args) {
        return commandLine.execute(args);
    }
}
