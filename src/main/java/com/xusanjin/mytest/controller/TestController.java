package com.xusanjin.mytest.controller;

import com.xusanjin.mytest.service.PersonService;
import com.xusanjin.mytest.util.result.Rsp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api(value = "测试", tags = {"test"})
public class TestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get/test")
    @ApiOperation(value = "演示", notes = "{\"pageSize\":10,\"pageNo\":1}")
    public Rsp getAdminPersonnelByType(@RequestParam(required = false) @ApiParam("1.劳务人员,2.管理人员") Integer type) {
        if (type == 1) {
            return Rsp.ok(personService.listPerson());
        } else {
            return Rsp.fail("fail 失败");
        }
    }
}
