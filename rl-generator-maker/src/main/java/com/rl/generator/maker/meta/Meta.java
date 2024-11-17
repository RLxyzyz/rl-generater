package com.rl.generator.maker.meta;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 任磊
 * @version 1.0
 * @project rl-generater
 * @description 元信息
 * @date 2024/11/17 13:52:46
 */
@NoArgsConstructor
@Data
public class Meta {

    private String name;
    private String description;
    private String basePackage;
    private String version;
    private String author;
    private String createTime;
    private FileConfigInfo fileConfig;
    private ModelConfigInfo modelConfig;

    @NoArgsConstructor
    @Data
    public static class FileConfigInfo {
        private String inputRootPath;
        private String outputRootPath;
        private String type;
        private List<FilesInfo> files;

        @NoArgsConstructor
        @Data
        public static class FilesInfo {
            private String inputPath;
            private String outputPath;
            private String type;
            private String generateType;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ModelConfigInfo {
        private List<Model> models;

        @NoArgsConstructor
        @Data
        public static class Model {
            private String type;
            private String name;
            private String description;
            private Object defaultValue;
            private String abbr;
        }


    }
}
