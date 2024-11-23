package com.rl.generator.maker.meta;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 元信息异常类
 * @date 2024/11/20 14:33:36
 */
public class MetaException extends RuntimeException{
    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
