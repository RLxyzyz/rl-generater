package ${basePackage}.maker.model;

import lombok.Data;

/**
 * @author ${author}
 * @version ${version}
 * @project rl-generater
 * @description ${description}
 * @date ${description}
 */
@Data
public class DataModel {
<#list modelConfig.models as model>

 <#if model.description??>
    /**
    * ${model.description}
    * */
</#if>
    private ${model.type} ${model.name} <#if model.defaultValue??>= ${model.defaultValue}</#if>;
</#list>
}
