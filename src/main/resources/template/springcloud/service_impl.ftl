<#include "assignlib.ftl">
package ${packagePath};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ${group_artfactId}.dao.${Mapper};
<#--import com.magic.basicdata.dao.SysUserRoleMappingMapper;-->
<#--import com.magic.basicdata.dto.${Dto};-->
import ${group_artfactId}.entity.${Entity};
<#--import com.magic.basicdata.entity.SysUserRuleRoleMappingEntity;-->
import ${group_artfactId}.service.${Service};
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
    public ${Entity} selectByPrimaryKey(<@Variable_Type_Keys keys=primaryKeys/>){
         return ${mapper}.selectByPrimaryKey(<@Variable_Keys keys=primaryKeys/>);
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
    public int deleteByPrimaryKey(<@Variable_Type_Keys keys=primaryKeys/>){
        return ${mapper}.deleteByPrimaryKey(<@Variable_Keys keys=primaryKeys/>);
    }
    <#else>
     public int deleteByPrimaryKey(${Entity} record){
        return ${mapper}.deleteByPrimaryKey(record);
    }
    </#if>

}
