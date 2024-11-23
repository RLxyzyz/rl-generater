package ${basePackage};

import ${basePackage}.cli.CommandExecutor;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
 */
public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        //args = new String[]{"generator","-l","-a","-o"};
        //args = new String[]{"list"};
        commandExecutor.execute(args);
    }
}
