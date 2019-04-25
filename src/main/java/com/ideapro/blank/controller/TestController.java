package com.ideapro.blank.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "文档接口")
public class TestController {
    @ApiOperation(value = "新增接口", notes = "新增漫画接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "漫画名", dataType = "String", required = true, paramType = "form"),
            @ApiImplicitParam(name = "actor", value = "作者", dataType = "String", required = true, paramType = "form")
    })
    @RequestMapping("word")
    public String helloWord(@RequestParam(value = "name") String name, @RequestParam(value = "actor") String actor) {
        return name + " " + actor;
    }

    @RequestMapping("/")
    public String test() {
        return "OK";
    }
}
