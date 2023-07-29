package com.csqf.zx.controller;

import com.csqf.zx.VO.TelephoneVO;
import com.csqf.zx.restult.ResponseResult;
import com.csqf.zx.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日期: 20237月29
 * 作者: XinForever
 */
@CrossOrigin
@RestController
@RequestMapping("/back")
public class BackController {

    @Autowired
    BackService backService;

    @GetMapping
    public ResponseResult<TelephoneVO> backList() {
        ResponseResult result = ResponseResult.SUCCESS();

        List<TelephoneVO> list =  backService.backList();
        result.setData(list);

        return result;
    }

    @PutMapping("{id}")
    public ResponseResult updateBack(@PathVariable Integer id,@RequestBody TelephoneVO telephoneVO) {
        ResponseResult result = ResponseResult.SUCCESS();

        backService.updateBack(id,telephoneVO);

        return result;
    }

    @DeleteMapping("{id}")
    public ResponseResult deleteBack(@PathVariable Integer id) {
        ResponseResult result = ResponseResult.SUCCESS();

        backService.deleteBack(id);

        return result;
    }

    @PostMapping
    public ResponseResult addBack(@RequestBody TelephoneVO telephoneVO) {
        ResponseResult result = ResponseResult.SUCCESS();

        backService.addBack(telephoneVO);

        return result;
    }

}
