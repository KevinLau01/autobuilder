<#include "assignlib.ftl">
package ${packagePath};

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import com.magic.common.dto.ResultDto;
import com.magic.common.utils.SignatureUtil;
import com.magic.common.utils.token.Token;
import com.magic.common.utils.token.TokenUtil;
import ${group_artfactId}.entity.${Entity};
import ${group_artfactId}.service.${Service};
import java.util.List;
import java.util.Map;

/**
 * Controller of ${Class}
 * @author ${author}
 * @date ${sysDate?date}
 */

@RestController
@RequestMapping("/${controller}")
public class ${Controller} {


    @Autowired
    private ${Service} ${service};


    //crud
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultDto set(@RequestBody ${Entity} record) {
        <#--record.setPassword(SignatureUtil.encodeStr(record.getLoginId().substring(record.getLoginId().length() - 6)));-->
        return new ResultDto(${service}.insertSelective(record), "xxx", "新增失败");
    }

    <#if (! isMappingTable)>
    @RequestMapping(value = "/{<#list primaryKeys as key>${controller}${key.nameJ?cap_first}</#list>}", method = RequestMethod.DELETE)
    public ResultDto del(<#list primaryKeys as key> @PathVariable("${controller}${key.nameJ?cap_first}") ${key.type} ${controller}${key.nameJ?cap_first}<#sep>,</#list> ) {
        return new ResultDto(${service}.deleteByPrimaryKey(<#list primaryKeys as key> ${controller}${key.nameJ?cap_first} </#list>), "xxx", "删除失败");
    }
    <#else>
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResultDto del(@RequestBody ${Entity} record) {
        return new ResultDto(${service}.deleteByPrimaryKey(record), "xxx", "删除失败");
    }
    </#if>

    <#if (! isMappingTable)>
    @RequestMapping(value = "/{${tableId}}", method = RequestMethod.PUT)
    public ResultDto update(@PathVariable("${tableId}") int ${tableId}, @RequestBody ${Entity} record) {
        record.setId(${tableId});
        return new ResultDto(${service}.updateByPrimaryKeySelective(record), "xxx", "更新失败");
    }

    @RequestMapping(value = "/{${tableId}}", method = RequestMethod.GET)
    public ResultDto getInfo(@PathVariable("${tableId}") int ${tableId}) {
        return new ResultDto(${service}.selectByPrimaryKey(${tableId}));
    }
    </#if>

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultDto getAll(@ModelAttribute ${Entity} record,
                            @RequestParam(value="pageNum" ,defaultValue = "1" ) int pageNum,
                            @RequestParam(value="pageSize", defaultValue = "20") int pageSize) {
        return new ResultDto(${service}.selectByCondition(record, pageNum, pageSize));
    }


    }
