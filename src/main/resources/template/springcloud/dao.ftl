<#include "assignlib.ftl">
package ${packagePath};

import ${groupId}.${artifactId}.entity.${Entity};
import java.util.List;

public interface ${Mapper}{

    <#if (! isMappingTable)>
    ${Entity} selectByPrimaryKey(Integer id);
    </#if>

    List<${Entity}> selectByCondition(${Entity} record);

    int insertSelective(${Entity} record);

    <#if (! isMappingTable)>int updateByPrimaryKeySelective(${Entity} record); </#if>

    int deleteByPrimaryKey(<#if ! isMappingTable>Integer id <#else> ${Entity} record </#if>);

}