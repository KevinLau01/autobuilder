<#include "assignlib.ftl">
package ${package_path};

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import com.magic.common.dto.ResultDto;
import com.magic.common.utils.SignatureUtil;
import com.magic.common.utils.token.Token;
import com.magic.common.utils.token.TokenUtil;
import ${groupId}.${artifactId}.entity.${Entity};
import ${groupId}.${artifactId}.service.${Service};
import java.util.List;
import java.util.Map;

/**
 * Controller of ${class_name}
 * @author ${author}
 * @date ${sysDate?date}
 */

@Controller
@RequestMapping("/${sub_table_name}")
public class ${Controller} {


    @Autowired
    private ${Service} ${service};


    //crud
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultDto set(@RequestBody ${Entity} record) {
        <#--record.setPassword(SignatureUtil.encodeStr(record.getLoginId().substring(record.getLoginId().length() - 6)));-->
        return new ResultDto(${service}.insertSelective(record), "xxx", "新增失败");
    }

    @RequestMapping(value = "/{${tableId}}", method = RequestMethod.DELETE)
    public ResultDto del(@PathVariable("${tableId}") int ${tableId}) {
        return new ResultDto(${service}.deleteByPrimaryKey(${tableId}), "xxx", "删除失败");
    }

    @RequestMapping(value = "/{${tableId}", method = RequestMethod.PUT)
    public ResultDto update(@PathVariable("${tableId}") int ${tableId}, @RequestBody ${Entity} record) {
        //todo
        return new ResultDto(${service}.updateByPrimaryKeySelective(record));
        <#--check.setLoginId(record.getLoginId());-->

        <#--List<SysUserDto> result = sysUserService.selectByCondition(check);-->
    <#--if ((result.size() == 1 && result.get(0).getId() != userId) || result.size() > 1) {-->
    <#--return new ResultDto("xxx", "输入的登陆名称已存在不可重复");-->
    }

    if (record.getPassword() != null) {
    record.setPassword(SignatureUtil.encodeStr(record.getPassword()));
    }

    record.setId(userId);
    return new ResultDto(sysUserService.updateByPrimaryKeySelective(record), "xxx", "//TODO 失败");
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResultDto getInfo(@PathVariable("userId") int userId) {
    return new ResultDto(sysUserService.selectByPrimaryKey(userId));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultDto getAll(@ModelAttribute SysUserEntity record,
    @RequestParam("pageNum") int pageNum,
    @RequestParam("pageSize") int pageSize) {
    return new ResultDto(sysUserService.selectByCondition(record, pageNum, pageSize));
    }


    }
