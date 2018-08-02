<#include "assignlib.ftl">
package ${packagePath};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.magic.basicdata.dao.${Mapper};
<#--import com.magic.basicdata.dao.SysUserRoleMappingMapper;-->
<#--import com.magic.basicdata.dto.${Dto};-->
import com.magic.basicdata.entity.${Entity};
<#--import com.magic.basicdata.entity.SysUserRuleRoleMappingEntity;-->
import com.magic.basicdata.service.${Service};
import java.util.List;


@Service
@Transactional
public class ${Class}ServiceImpl implements ${Service} {

    @Autowired
    private ${Mapper} ${mapper};

    @Override
    public PageInfo selectByCondition(${Entity} record, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(${mapper}.selectByCondition(record));
    }

    @Override
    public List<${Entity}> selectByCondition(${Entity} record){
        return ${mapper}.selectByCondition(record);
    }

    <#if ! isMappingTable>
    @Override
    public ${Entity} selectByPrimaryKey(Integer id){
         return ${mapper}.selectByPrimaryKey(id);
    }
    </#if>

    @Transactional//(propagation= Propagation.REQUIRED)
    @Override
    public int insertSelective(${Entity} record){
        record.setCreateFields();
        return  ${mapper}.insertSelective(record);
        <#--${Entity} checkResult = ${mapper}.selectByLoginId(record);-->
        <#--if (checkResult != null) {-->
            <#--return -1;-->
        <#--} else {-->
            <#--record.setCreateFields();-->
            <#--return  ${mapper}.insertSelective(record);-->
        <#--}-->
    }

    <#if (! isMappingTable)>
    @Override
    public int updateByPrimaryKeySelective(${Entity} record){
        record.setUpdateFields();
        return ${mapper}.updateByPrimaryKeySelective(record);
    }
    </#if>

    @Override
    <#if (! isMappingTable)>
    public int deleteByPrimaryKey(Integer id){
        return ${mapper}.updateByPrimaryKeySelective(id);
    }
    <#else>
     public int deleteByPrimaryKey(${Entity} record){
        return ${mapper}.updateByPrimaryKeySelective(${Entity} record);
    }
    </#if>

}
