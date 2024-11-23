package com.rl.generator.maker.meta;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.rl.generator.maker.meta.Meta.FileConfigInfo;
import com.rl.generator.maker.meta.Meta.FileConfigInfo.FilesInfo;
import com.rl.generator.maker.meta.Meta.ModelConfigInfo;
import com.rl.generator.maker.meta.Meta.ModelConfigInfo.Model;
import com.rl.generator.maker.meta.enums.FileGenerateTypeEnum;
import com.rl.generator.maker.meta.enums.FileTypeEnum;
import com.rl.generator.maker.meta.enums.ModelTypeEnum;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 元信息校验类
 * @date 2024/11/20 14:35:14
 */
public class MetaValidator {
    public static void validateAndSet(Meta meta) {
        //基础信息校验
        validateBase(meta);
        validateFile(meta.getFileConfig());
        validateModel(meta.getModelConfig());
    }

    private static void validateBase(Meta meta) {
        String name = meta.getName();
        String author = meta.getAuthor();
        String description = meta.getDescription();
        String createTime = meta.getCreateTime();
        String basePackage = meta.getBasePackage();
        String version = meta.getVersion();
        name = StrUtil.blankToDefault(name, "myGenerator");
        meta.setName(name);
        author = StrUtil.blankToDefault(author, "任磊");
        meta.setAuthor(author);
        description = StrUtil.blankToDefault(description, "我的代码生成器");
        meta.setDescription(description);
        basePackage = StrUtil.blankToDefault(basePackage, "com.rl");
        meta.setBasePackage(basePackage);
        version = StrUtil.blankToDefault(version, "1.0");
        meta.setVersion(version);
        createTime = StrUtil.blankToDefault(createTime, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        meta.setCreateTime(createTime);
    }

    private static void validateFile(FileConfigInfo fileConfig) {
        //文件校验
        if (ObjectUtil.isNull(fileConfig)) {
            return;
        }
        List<FilesInfo> files = fileConfig.getFiles();
        String resourceRootPath = fileConfig.getResourceRootPath();
        String inputRootPath = fileConfig.getInputRootPath();
        String outputRootPath = fileConfig.getOutputRootPath();
        String fileType = fileConfig.getType();
        if (StrUtil.isBlank(resourceRootPath)) {
            throw new MetaException("资源路径不能为空");
        }
        if (StrUtil.isBlank(inputRootPath)) {
            String defaultInputRootPath =
                ".source/" + FileUtil.getLastPathEle(Paths.get(resourceRootPath))
                    .getFileName().toString();
            fileConfig.setInputRootPath(defaultInputRootPath);
        }
        if (StrUtil.isBlank(outputRootPath)) {
            String defaultOutputRootPath = "generated";
            fileConfig.setOutputRootPath(defaultOutputRootPath);
        }
        if (StrUtil.isBlank(fileType)) {
            String defaultFileType = FileTypeEnum.DIR.getValue();
            fileConfig.setType(defaultFileType);
        }
        for (FilesInfo file : files) {
            String type = file.getType();
            String generateType = file.getGenerateType();
            String inputPath = file.getInputPath();
            String outputPath = file.getOutputPath();
            if (StrUtil.isBlank(inputPath)) {
                throw new MetaException("文件输入路径不能为空");
            }
            String defaultOutputPath = inputPath;
            if (StrUtil.isBlank(outputPath)) {
                file.setOutputPath(defaultOutputPath);
            }
            //type默认如果有文件后缀则是file，否则是dir
            if (StrUtil.isBlank(type)) {
                String fileSuffix = FileUtil.getSuffix(inputPath);
                if (StrUtil.isNotBlank(fileSuffix)) {
                    type = FileTypeEnum.FILE.getValue();
                } else {
                    type = FileTypeEnum.DIR.getValue();
                }
                file.setType(type);
            }
            //文件生成类型，如果文件结尾部位ftl就是static，否则就是dynamic
            if (StrUtil.isBlank(generateType)) {
                if (inputPath.endsWith(".ftl")) {
                    generateType = FileGenerateTypeEnum.DYNAMIC.getValue();
                } else {
                    generateType = FileGenerateTypeEnum.STATIC.getValue();
                }
                file.setGenerateType(generateType);
            }
        }
    }

    private static void validateModel(ModelConfigInfo modelConfig) {
        //模型配置校验
        if (ObjectUtil.isNull(modelConfig)) {
            return;
        }
        List<Model> models = modelConfig.getModels();
        if (ObjectUtil.isNotNull(models)) {
            for (Model model : models) {
                String modelName = model.getName();
                String type = model.getType();
                String modelDescription = model.getDescription();
                String abbr = model.getAbbr();
                Object defaultValue = model.getDefaultValue();
                if (StrUtil.isBlank(modelName)) {
                    throw new MetaException("模型名称不能为空");
                }
                if (StrUtil.isBlank(type)) {
                    String defaultType = ModelTypeEnum.STRING.getValue();
                    model.setType(defaultType);
                }

            }
        }

    }
}


