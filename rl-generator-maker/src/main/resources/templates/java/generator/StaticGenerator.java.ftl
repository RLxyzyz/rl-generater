package ${basePackage}.cli.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.file.StandardCopyOption;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${createTime}
 */
public class StaticGenerator {
    /**
     * @desciption 通过hutool工具类复制文件
     * @author ${author}
     * @data ${createTime}
     * */
    public void copyFile(String srcFilePath,String destFilePath,boolean override)
    {
        FileUtil.copy(srcFilePath,destFilePath,override);
    }

}
