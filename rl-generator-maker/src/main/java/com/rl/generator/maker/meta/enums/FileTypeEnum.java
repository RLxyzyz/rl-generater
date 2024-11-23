package com.rl.generator.maker.meta.enums;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 文件类型枚举类
 * @date 2024/11/20 16:08:53
 */
public enum FileTypeEnum {
    DIR("目录","dir"),
    FILE("文件","file");

    private final String text;


    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
