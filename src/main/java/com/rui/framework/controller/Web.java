package com.rui.framework.controller;

import com.rui.framework.result.Result;
import com.rui.framework.result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Web {
    @RequestMapping("/404")
    public Result fourZeroFour(){
        return Result.failure(ResultCode.FOUR_ZERO_FOUR);
    }
}
