<#include "assignlib.ftl">
package ${packagePath};

import com.magic.common.entity.BaseEntity;
import lombok.Data;
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
public class  ${Entity} extends BaseEntity {

<#list columns as c><#if ! hasItem(BaseEntityColumns,c.nameJ)>
    private ${c.type}	${c.nameJ};		<#if (c.remark?exists && c.remark!="")> /* ${c.remark} */ </#if>
</#if></#list>

}