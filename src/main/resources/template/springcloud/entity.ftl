<#include "assignlib.ftl">
package ${packagePath};

import com.magic.common.entity.BaseEntity;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<#list poImportList as im>
import ${im};
</#list>

/**
 * POJO:${Entity}
 *
 * @author ${author}
 * @date ${sysDate?date}
 */

@Data
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class  ${Entity} extends BaseEntity {

<#list columns as c><#if ! hasItem(BaseEntityColumns,c.nameJ)>
    <#if c.nameJ="id"> @ApiModelProperty(hidden = true)</#if>
    private ${c.type}	${c.nameJ};		<#if (c.remark?exists && c.remark!="")> /* ${c.remark} */ </#if>
</#if></#list>

}