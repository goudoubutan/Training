package com.csqf.zx.mapper;

import com.csqf.zx.DO.FoodDO;
import com.csqf.zx.VO.FoodVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日期: 2023年8月01日
 * 时间: 8:15
 * 作者: XinForever
 */
public interface FoodMapper {
    List<FoodDO> foodList();

    void updateFood(Integer fid,@Param("food") FoodVO foodVO);

    void addFood(@Param("food") FoodDO result);

    void deleteFood(Integer fid);
}
