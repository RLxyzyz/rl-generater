package com.rl.generator.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description
 * @date 2024/11/17 14:03:37
 */
public class MetaManager {
    private static volatile Meta meta;

    public static Meta newInstance(){
        if (meta==null){
            synchronized (MetaManager.class){
                if (meta==null){
                    meta = initMeat();
                }
            }
        }
        return meta;
    }

    private static Meta initMeat() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        // TODO: 2024/11/17 数据检验
        return JSONUtil.toBean(metaJson,Meta.class);
    }
}
