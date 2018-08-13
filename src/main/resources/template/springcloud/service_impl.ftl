<#include "assignlib.ftl">
package ${packagePath};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.magic.common.exception.SystemException;

import ${group_artfactId}.dao.${Mapper};
<#--import com.magic.basicdata.dao.SysUserRoleMappingMapper;-->
<#--import com.magic.basicdata.dto.${Dto};-->
import ${group_artfactId}.entity.${Entity};
<#--import com.magic.basicdata.entity.SysUserRuleRoleMappingEntity;-->
import ${group_artfactId}.service.${Service};
import java.util.List;

/**
 * ServiceImpl of ${Class}
 * @author ${author}
 * @date ${sysDate?date}
 */

@Service
@Transactional
public class ${Class}ServiceImpl implements ${Service} {

    @Resource
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

    @Transactional
    @Override
    public int insertSelective(${Entity} record){
        <#list uniqueIndexs as u>
        <#assign UniqueKey=u.nameJ?cap_first>
        if(record.get${UniqueKey}()!=null){
            ${Entity} check=new ${Entity}();
            check.set${UniqueKey}(record.get${UniqueKey}());
            List<${Entity}> checkRes=${mapper}.selectByCondition(check);
            if(checkRes!=null){
                return -1;//${UniqueKey}_ALREADY_EXIST
            }
        }
        </#list>
        <#if ! isMappingTable>record.setCreateFields();</#if>
        int res= ${mapper}.insertSelective(record);
        if(res==1){
            //关联表操作，先删除再增加
            return 1;
        } else {
             throw new SystemException();
        }
    }

    <#if (! isMappingTable)>
    @Override
    public int updateByPrimaryKeySelective(${Entity} record){
        <#list uniqueIndexs as u>
            <#assign UniqueKey=u.nameJ?cap_first>
        if(record.get${UniqueKey}()!=null){
            ${Entity} check=new ${Entity}();
            check.set${UniqueKey}(record.get${UniqueKey}());
            List<${Entity}> checkRes=${mapper}.selectByCondition(check);
            if(checkRes!=null&&checkRes.get(0).get${PrimaryKey}()!=record.get${PrimaryKey}()){
                return -1;//${UniqueKey}_ALREADY_EXIST
            }
        }
        </#list>
        record.setUpdateFields();
        int res=${mapper}.updateByPrimaryKeySelective(record);
        if(res==1){
            //关联表操作，先删除再增加
            return 1;
        } else {
             throw new SystemException();
        }
    }
    </#if>

    @Override
    <#if (! isMappingTable)>
    public int deleteByPrimaryKey(<@Variable_Type_Keys keys=primaryKeys/>){
        ${Entity} record=new ${Entity}();
        <#list primaryKeys as k>
        <#assign PrimaryKey=k.nameJ?cap_first>
        record.set${PrimaryKey}(${PrimaryKey?uncap_first});
        </#list>
        record.setDeleteFields();
        int delRes=${mapper}.updateByPrimaryKeySelective(record);
        if(delRes==1){
            return 1;
        }
        else {
            throw new SystemException();
        }
    }
    <#else>
     public int deleteByPrimaryKey(${Entity} record){
        return ${mapper}.deleteByPrimaryKey(record);
    }
    </#if>

}
