package com.csqf.zx.controller;

import com.csqf.zx.VO.UserBackVO;
import com.csqf.zx.restult.ResponseResult;
import com.csqf.zx.service.SatisfactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 日期: 2023年7月29日
 * 时间: 10:33
 * 作者: XinForever
 */
@RestController
@RequestMapping("/satisfaction")
@CrossOrigin
public class SatisfactionController {

    @Autowired
    SatisfactionService satisfactionService;

    @GetMapping
    public ResponseResult satisfactionList(){
        ResponseResult result = ResponseResult.SUCCESS();

        List<UserBackVO> list =  satisfactionService.satisfactionList();
        result.setData(list);

        return result;
    }

}
