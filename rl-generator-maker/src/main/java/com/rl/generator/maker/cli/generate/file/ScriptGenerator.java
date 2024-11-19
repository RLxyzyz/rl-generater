package com.rl.generator.maker.cli.generate.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 脚本文件生成
 * @date 2024/11/19 15:46:59
 */
public class ScriptGenerator {
    public void doGenerate(String outputPath,String jarPath){
        //Linux
        StringBuilder sb = new StringBuilder();
        sb.append("#!/bin/bash").append("\n");
        sb.append(String.format("java -jar %s \"$@\"",jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(), new File(outputPath));
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
        try {
            Files.setPosixFilePermissions(new File(outputPath).toPath(), permissions);
        } catch (IOException e) {

        }
        //Windows
        sb.append("@echo off").append("\n");
        sb.append(String.format("java -jar %s %%*",jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(), outputPath+".bat");
    }
}
