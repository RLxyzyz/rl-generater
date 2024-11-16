package com.rl.generater.basic.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description
 * @date 2024/11/16 13:40:42
 */
@Command(name="list",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override public void run() {
        //查看所有文件
        String projectPath = System.getProperty("user.dir");
        String parentPath = new File(projectPath).getParent();
        String inputPath = new File(parentPath,"demo/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
