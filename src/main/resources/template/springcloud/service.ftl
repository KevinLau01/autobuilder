<#include "assignlib.ftl">
package ${packagePath};

import com.github.pagehelper.PageInfo;
import ${group_artfactId}.entity.${Entity};
import java.util.List;

/**
 * Service of ${Class}
 * @author ${author}
 * @date ${sysDate?date}
 */

public interface ${Service}{

    PageInfo selectByCondition(${Entity} record, int pageNum, int pageSize);

    List<${Entity}> selectByCondition(${Entity} record);

    <#if (! isMappingTable)>
    ${Entity} selectByPrimaryKey(<@Variable_Type_Keys keys=primaryKeys/>);
    </#if>

    int insertSelective(${Entity} record);

    <#if (! isMappingTable)>
    int updateByPrimaryKeySelective(${Entity} record);
    </#if>

    int deleteByPrimaryKey(<#if ! isMappingTable><@Variable_Type_Keys keys=primaryKeys/><#else> ${Entity} record </#if>);

}