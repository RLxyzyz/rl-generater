package com.rl.generator.maker.model;

import lombok.Data;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 模板的模型
 * @date 2024/11/15 21:12:29
 */
@Data
public class DataModel {
    /**
     * 作者
     * */
    private String author;


    /**
     * 输出
     * */
    private String output;

    /**
     * 是否循环
     * */
    private boolean loop;
}
