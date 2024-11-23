package com.rl.generator.maker.meta.enums;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 模型字段类型枚举类
 * @date 2024/11/20 16:08:53
 */
public enum ModelTypeEnum {
    STRING("字符串","String"),
    BOOLEAN("布尔类型","boolean");

    private final String text;


    private final String value;

    ModelTypeEnum(String text, String value) {
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
