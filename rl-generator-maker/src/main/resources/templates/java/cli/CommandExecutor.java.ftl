package ${basePackage}.cli;

import ${basePackage}.cli.command.ConfigCommand;
import ${basePackage}.cli.command.GeneratorCommand;
import ${basePackage}.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
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
