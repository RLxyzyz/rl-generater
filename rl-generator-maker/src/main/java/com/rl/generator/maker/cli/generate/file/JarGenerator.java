package com.rl.generator.maker.cli.generate.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 打包
 * @date 2024/11/19 15:10:05
 */
public class JarGenerator {
    public static void doGenerator(String projectPath) throws IOException, InterruptedException {
        String winMvnCommmand = "mvn.cmd clean package -Dmaven.test.skip=true";
        String otherMvnCommand = "mvn clean package -Dmaven.test.skip=true";
        ProcessBuilder builder=new ProcessBuilder(winMvnCommmand.split(" "));
        builder.directory(new File(projectPath));

        Process process = builder.start();
        InputStream inputStream = process.getInputStream();
        BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        int resCode = process.waitFor();
        System.out.println("resCode:"+resCode);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerator("F:\\code\\backend\\rl-generater\\rl-generater-basic");
    }
}
