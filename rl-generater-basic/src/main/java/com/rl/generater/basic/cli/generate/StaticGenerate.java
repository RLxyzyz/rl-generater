package com.rl.generater.basic.cli.generate;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.file.StandardCopyOption;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 静态生成文件
 * @date 2024/11/15 19:08:17
 */
public class StaticGenerate {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String srcFilePath = projectPath + File.separator+"demo/acm-template";
        String destFilePath = projectPath;
        copyFile(srcFilePath,destFilePath,true);
    }
    /**
     * @desciption 通过hutool工具类复制文件
     * @author 任磊
     * @data 2024/11/15 19:08:17
     * */
    public static void copyFile(String srcFilePath,String destFilePath,boolean override)
    {
        FileUtil.copy(srcFilePath,destFilePath,override);
    }
    /**
     * @description 递归实现文件复制
     * @author 任磊
     * @data
     * */
    public static void internalCopyFile(String srcFilePath,String destFilePath){
        if (srcFilePath.equals(destFilePath)){
            return;
        }
        if (!FileUtil.exist(srcFilePath)){
            return;
        }
        if (FileUtil.isDirectory(srcFilePath)){
            File srcFile = new File(srcFilePath);
            String name = srcFile.getName();
            String destPath = destFilePath + File.separator + name;
            FileUtil.mkdir(destPath);
            File[] files = FileUtil.ls(srcFilePath);
            for (File file : files) {
                internalCopyFile(file.getAbsolutePath(),destPath);
            }
        }else{
            String destPath = destFilePath + File.separator + FileUtil.getName(srcFilePath);
            FileUtil.copyFile(srcFilePath,destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
