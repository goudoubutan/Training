package com.csqf.zx.controller;

import com.csqf.zx.VO.FoodVO;
import com.csqf.zx.restult.ResponseResult;
import com.csqf.zx.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日期: 2023年8月01日
 * 时间: 8:14
 * 作者: XinForever
 */
@RestController
@RequestMapping("/food")
@CrossOrigin
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping
    public ResponseResult foodList() {
        ResponseResult result = ResponseResult.SUCCESS();

        List<FoodVO> list = foodService.foodList();
        result.setData(list);

        return result;
    }

    @PutMapping("{fid}")
    public ResponseResult updateFood(@PathVariable Integer fid, @RequestBody FoodVO foodVO) {
        ResponseResult result = ResponseResult.SUCCESS();

        foodService.updateFood(fid, foodVO);

        return result;
    }

    @PostMapping
    public ResponseResult addFood(@RequestBody FoodVO foodVO) {
        ResponseResult result = ResponseResult.SUCCESS();

        foodService.addFood(foodVO);

        return result;
    }

    @DeleteMapping("{fid}")
    public ResponseResult deleteFood(@PathVariable Integer fid) {
        ResponseResult result = ResponseResult.SUCCESS();

        foodService.deleteFood(fid);

        return result;
    }

}
