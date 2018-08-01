<#include "assignlib.ftl">
package ${package_path};

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ${groupId}.common.dto.ResultDto;
import ${groupId}.common.utils.SignatureUtil;
import ${groupId}.common.utils.token.Token;
import ${groupId}.common.utils.token.TokenUtil;
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
@RequestMapping("/${class_name?uncap_first}")
public class ${class_name}Controller {


    @Autowired
    private ${Service} ${service};


    //crud
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultDto set(@RequestBody SysUserDto record) {
        record.setPassword(SignatureUtil.encodeStr(record.getLoginId().substring(record.getLoginId().length() - 6)));
        return new ResultDto(sysUserService.insertSelective(record), "xxx", "新增用户失败，登录名称已存在");
    }

    @RequestMapping(value = "/{userId}/reset", method = RequestMethod.POST)
    public ResultDto resetPassword(@PathVariable("userId") int userId) {
        SysUserEntity user = sysUserService.selectByPrimaryKey(userId);
        if (user == null) {
            return new ResultDto("001", "//TODO 失败");
        }
        //更新密码
        SysUserDto updataParam = new SysUserDto();
        updataParam.setId(user.getId());
        updataParam.setPassword(SignatureUtil.encodeStr(user.getLoginId().substring(user.getLoginId().length() - 6)));
        return new ResultDto(sysUserService.updateByPrimaryKeySelective(updataParam), "001", "//TODO 失败");
    }

    @RequestMapping(value = "/pwd", method = RequestMethod.PUT)
    public ResultDto changePwd(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> params) {
        Token token = TokenUtil.getTokenByHeaders(headers);
        //校验原有密码正确性
        SysUserEntity user = sysUserService.selectByPrimaryKey(token.getUid());
        if (user != null && SignatureUtil.matches(params.get("password"), user.getPassword())) {
            //更新密码
            SysUserDto updataParam = new SysUserDto();
            updataParam.setId(user.getId());
            updataParam.setPassword(SignatureUtil.encodeStr(params.get("newPassword")));
            sysUserService.updateByPrimaryKeySelective(updataParam);
            return new ResultDto();
        } else {
            return new ResultDto("200011", "原密码错误");
        }
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResultDto del(@PathVariable("userId") int userId) {
        return new ResultDto(sysUserService.deleteByPrimaryKey(userId), "xxx", "//TODO 失败");
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResultDto update(@PathVariable("userId") int userId, @RequestBody SysUserDto record) {
        SysUserEntity check = new SysUserEntity();
        check.setLoginId(record.getLoginId());

        List<SysUserDto> result = sysUserService.selectByCondition(check);
    if ((result.size() == 1 && result.get(0).getId() != userId) || result.size() > 1) {
    return new ResultDto("xxx", "输入的登陆名称已存在不可重复");
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
