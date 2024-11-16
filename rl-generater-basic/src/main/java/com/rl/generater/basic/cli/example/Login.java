package com.rl.generater.basic.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 交互式命令行
 * @date 2024/11/16 12:40:04
 */
public class Login implements Callable {
    @Option(names = "-u", description = "用户名", required = true)
    String user;
    @Option(names = "-p", description = "密码",arity = "0..1",required = true,interactive = true)
    String password;
    @Option(names = "-cp", description = "确认密码",arity = "0..1",required = true,interactive = true)
    String checkedPassword;
    @Override public Object call() throws Exception {
        System.out.println("用户名：" + user);
        System.out.println("密码：" + password);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","1234renlei","-p");
    }
}
