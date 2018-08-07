<#include "assignlib.ftl">
package ${packagePath};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.magic.common.dto.ResultDto;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import ${group_artfactId}.entity.${Entity};
import ${group_artfactId}.service.${Service};


/**
 * Controller of ${Class}
 * @author ${author}
 * @date ${sysDate?date}
 */

@EnableSwagger2
@RestController
@RequestMapping("/${controller}")
public class ${Controller} {


    @Autowired
    private ${Service} ${service};


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultDto set(@RequestBody ${Entity} record) {
        <#--record.setPassword(SignatureUtil.encodeStr(record.getLoginId().substring(record.getLoginId().length() - 6)));-->
        return new ResultDto(${service}.insertSelective(record), "xxx", "新增失败");
    }

    <#if (! isMappingTable)>
    @RequestMapping(value = "/{<#if (primaryKeys?size>1)>"keys"<#else>${controller}${primaryKeys[0].nameJ?cap_first}</#if>}", method = RequestMethod.DELETE)
    public ResultDto del(<@PathVariable_Keys keys=primaryKeys pre=controller/>) {
        return new ResultDto(${service}.deleteByPrimaryKey(<@Path_Keys keys=primaryKeys pre=controller/>), "xxx", "删除失败");
    }
    <#else>
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResultDto del(@RequestBody ${Entity} record) {
        return new ResultDto(${service}.deleteByPrimaryKey(record), "xxx", "删除失败");
    }
    </#if>

    <#if (! isMappingTable)>
    @RequestMapping(value = "/{<#if (primaryKeys?size>1)>"keys"<#else>${controller}${primaryKeys[0].nameJ?cap_first}</#if>}", method = RequestMethod.PUT)
    public ResultDto update(<@PathVariable_Keys keys=primaryKeys pre=controller/>, @RequestBody ${Entity} record) {
        record.setId(<@Path_Keys keys=primaryKeys pre=controller/>);
        return new ResultDto(${service}.updateByPrimaryKeySelective(record), "xxx", "更新失败");
    }

    @RequestMapping(value = "/{<#if (primaryKeys?size>1)>"keys"<#else>${controller}${primaryKeys[0].nameJ?cap_first}</#if>}", method = RequestMethod.GET)
    public ResultDto getInfo(<@PathVariable_Keys keys=primaryKeys pre=controller/>) {
        return new ResultDto(${service}.selectByPrimaryKey(<@Path_Keys keys=primaryKeys pre=controller/>));
    }
    </#if>

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultDto getAll(@ModelAttribute ${Entity} record,
                            @RequestParam(value="pageNum" ,defaultValue = "1" ) int pageNum,
                            @RequestParam(value="pageSize", defaultValue = "20") int pageSize) {
        return new ResultDto(${service}.selectByCondition(record, pageNum, pageSize));
    }


    }
