package com.csqf.zx.service;

import com.csqf.zx.VO.FoodVO;

import java.util.List;

/**
 * 日期: 2023年8月01日
 * 时间: 8:14
 * 作者: XinForever
 */
public interface FoodService {
    List<FoodVO> foodList();

    void updateFood(Integer fid, FoodVO foodVO);

    void addFood(FoodVO foodVO);

    void deleteFood(Integer fid);
}
