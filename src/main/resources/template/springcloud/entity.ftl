package ${package_path};

import ${groupId}.common.entity.BaseEntity;
import lombok.Data;
<#list poImportList as im>
import ${im};
</#list>

/**
 * POJO:${class_name}
 *
 * @author ${author}
 * @date ${sysDate?date}
 */

@Data
public class  ${class_name} extends BaseEntity {

<#list table_column as c>
    <#if (c.name!="id")>private ${c.type}	${c.nameJ};		<#if (c.remark?exists && c.remark!="")> /* ${c.remark} */ </#if></#if>
</#list>

}