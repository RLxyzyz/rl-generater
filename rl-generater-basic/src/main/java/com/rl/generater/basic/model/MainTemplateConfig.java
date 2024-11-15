package com.rl.generater.basic.model;

import lombok.Data;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 模板的模型
 * @date 2024/11/15 21:12:29
 */
@Data
public class MainTemplateConfig {
    /**
     * 作者
     * */
    private String author;

    /**
     * 时间
     * */
    private String date;

    /**
     * 输出
     * */
    private String output;

    /**
     * 是否循环
     * */
    private boolean loop;
}