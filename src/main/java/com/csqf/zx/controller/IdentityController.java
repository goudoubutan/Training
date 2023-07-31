package com.csqf.zx.controller;

import com.csqf.zx.VO.IdentityVO;
import com.csqf.zx.restult.ResponseResult;
import com.csqf.zx.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 日期: 2023年7月31日
 * 时间: 8:53
 * 作者: XinForever
 */
@CrossOrigin
@RestController
@RequestMapping("/identity")
public class IdentityController {

    @Autowired
    IdentityService identityService;

    @GetMapping
    public ResponseResult identityList() {
        ResponseResult result = ResponseResult.SUCCESS();

        List<IdentityVO> list = identityService.identityList();
        result.setData(list);

        return result;
    }

}
