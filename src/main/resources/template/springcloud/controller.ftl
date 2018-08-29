<#include "assignlib.ftl">
package ${packagePath};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.magic.common.dto.ResultDto;
import com.magic.common.validator.ValidatorService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import ${group_artfactId}.constants.ErrCode;
import ${group_artfactId}.entity.${Entity};
import ${group_artfactId}.service.${Service};


/**
 * Controller of ${Class}
 * @author ${author}
 * @date ${sysDate?date}
 */

@EnableSwagger2
@RestController
@RequestMapping("/${subTableName}")
public class ${Controller} {

    @Autowired
    private ${Service} ${service};
    @Autowired
    private ValidatorService validatorService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultDto set(@RequestBody ${Entity} record) {
        //参数验证
        //validatorService.validate(record);
        ${service}.insertSelective(record);
        return new ResultDto();
    }

    <#if (! isMappingTable)>
    @RequestMapping(value = "/{<#if (primaryKeys?size>1)>"keys"<#else>${subTableName}${PrimaryKey}</#if>}", method = RequestMethod.DELETE)
    public ResultDto del(<@PathVariable_Keys keys=primaryKeys pre=subTableName/>) {
        ${service}.deleteByPrimaryKey(<@Path_Keys keys=primaryKeys pre=subTableName/>);
        return new ResultDto();
    }
    <#else>
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResultDto del(@RequestBody ${Entity} record) {
        ${service}.deleteByPrimaryKey(record);
        return new ResultDto();
    }
    </#if>

    <#if (! isMappingTable)>
    @RequestMapping(value = "/{<#if (primaryKeys?size>1)>"keys"<#else>${subTableName}${PrimaryKey}</#if>}", method = RequestMethod.PUT)
    public ResultDto update(<@PathVariable_Keys keys=primaryKeys pre=subTableName/>, @RequestBody ${Entity} record) {
        <#list primaryKeys as key>record.set${key.nameJ?cap_first}(${subTableName}${key.nameJ?cap_first});</#list>
        ${service}.updateByPrimaryKeySelective(record);
        return new ResultDto();
    }

    @RequestMapping(value = "/{<#if (primaryKeys?size>1)>"keys"<#else>${subTableName}${PrimaryKey}</#if>}", method = RequestMethod.GET)
    public ResultDto getInfo(<@PathVariable_Keys keys=primaryKeys pre=subTableName/>) {
        return new ResultDto(${service}.selectByPrimaryKey(<@Path_Keys keys=primaryKeys pre=subTableName/>));
    }
    </#if>

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultDto getAll(@ModelAttribute ${Entity} record,
                            @RequestParam(value="pageNum" ,defaultValue = "1" ) int pageNum,
                            @RequestParam(value="pageSize", defaultValue = "20") int pageSize) {
        return new ResultDto(${service}.selectByCondition(record, pageNum, pageSize));
    }


    }
