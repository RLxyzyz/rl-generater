package com.rl.generator.maker.meta.enums;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 文件生成类型枚举类
 * @date 2024/11/20 16:08:53
 */
public enum FileGenerateTypeEnum {
    DYNAMIC("动态生成","dynamic"),
    STATIC("静态生成","static");

    private final String text;


    private final String value;

    FileGenerateTypeEnum(String text, String value) {
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
