<#include "assignlib.ftl">
package ${package_path};

import com.github.pagehelper.PageInfo;
import ${groupId}.${artifactId}.entity.${Entity};
import java.util.List;

public interface ${Service}{

    PageInfo selectByCondition(${Entity} record, int pageNum, int pageSize);

    List<${Entity}> selectByCondition(${Entity} record);

    <#if (! isMappingTable)>
    ${Entity} selectByPrimaryKey(Integer id);
    </#if>

    int insertSelective(${Entity} record);

    <#if (! isMappingTable)>
    int updateByPrimaryKeySelective(${Entity} record);
    </#if>

    int deleteByPrimaryKey(<#if ! isMappingTable>Integer id <#else> ${Entity} record </#if>);

}