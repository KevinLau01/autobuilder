<#include "assignlib.ftl">
package ${package_path};

import ${groupId}.${artifactId}.entity.${Entity};
import java.util.List;

public interface ${Mapper}{

    ${Entity} selectByPrimaryKey(Integer id);

    List<${Entity}> selectByCondition(${Entity} record);

    int insertSelective(${Entity} record);

    int updateByPrimaryKeySelective(${Entity} record);

    int deleteByPrimaryKey(Integer id);

}