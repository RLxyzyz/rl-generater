package ${basePackage}.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
 */
@Command(name="list",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override public void run() {
        //查看所有文件
        String inputPath = "${fileConfig.inputRootPath}";
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
