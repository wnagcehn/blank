package com.ideapro.blank.controller;

import com.ideapro.blank.common.Exception.BizException;
import com.ideapro.blank.common.result.Result;
import com.ideapro.blank.common.result.ResultUtils;
import com.ideapro.blank.model.vo.UserVo;
import com.ideapro.blank.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user/v1")
@RestController
@Api(tags = "用户")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/queryUser/{username}", method = RequestMethod.GET)
    @ApiOperation(value = "查询用戶信息", notes = "查询用戶信息")
    // @ApiImplicitParam(name = "username ", paramType = "path", dataType = "String", required = true)
    // @ModelAttribute注解可以将Json格式转为form表单格式
    private Result queryUser(@PathVariable String username) {
        if (StringUtils.isBlank(username)) {
            return ResultUtils.error(400, "用户信息为空！");
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        List<UserVo> list;
        try {
            list = userService.query(param);
        }catch (BizException e){
            return ResultUtils.error(400, e.getMessage());
        }
        return ResultUtils.success(list);
    }
}
