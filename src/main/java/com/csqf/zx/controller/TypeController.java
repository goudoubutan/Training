package com.csqf.zx.controller;

import com.csqf.zx.DO.TypeDO;
import com.csqf.zx.VO.TypeVO;
import com.csqf.zx.restult.ResponseResult;
import com.csqf.zx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 日期: 2023年8月01日
 * 时间: 8:45
 * 作者: XinForever
 */
@RestController
@RequestMapping("/types")
@CrossOrigin
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping
    public ResponseResult getAllType(){
        ResponseResult result = ResponseResult.SUCCESS();
       List<TypeVO> list = typeService.getAllType();
       result.setData(list);
        return result;
    }

}
