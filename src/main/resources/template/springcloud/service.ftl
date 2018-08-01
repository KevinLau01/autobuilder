<#include "assignlib.ftl">
package ${package_path};

import com.github.pagehelper.PageInfo;
import ${groupId}.${artifactId}.entity.${Entity};
import java.util.List;

public interface ${Service}{

    PageInfo selectByCondition(${Entity} record, int pageNum, int pageSize);

    ${Entity} selectByPrimaryKey(Integer id);

    List<${Entity}> selectByCondition(${Entity} record);

    int insertSelective(${Entity} record);

    int updateByPrimaryKeySelective(${Entity} record);

    int deleteByPrimaryKey(Integer id);

}