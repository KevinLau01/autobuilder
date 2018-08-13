<#include "assignlib.ftl">
package ${packagePath};

import ${groupId}.${artifactId}.entity.${Entity};
import java.util.List;

/**
 * Dao of ${Class}
 * @author ${author}
 * @date ${sysDate?date}
 */

public interface ${Mapper}{

    <#if (! isMappingTable)>
    ${Entity} selectByPrimaryKey(<@Variable_Type_Keys keys=primaryKeys/>);
    </#if>

    List<${Entity}> selectByCondition(${Entity} record);

    int insertSelective(${Entity} record);

    <#if (! isMappingTable)>int updateByPrimaryKeySelective(${Entity} record); </#if>

    int deleteByPrimaryKey(<#if ! isMappingTable><@Variable_Type_Keys keys=primaryKeys/><#else> ${Entity} record </#if>);

}