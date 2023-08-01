package com.csqf.zx.service.impl;

import com.csqf.zx.DO.FoodDO;
import com.csqf.zx.VO.FoodVO;
import com.csqf.zx.mapper.FoodMapper;
import com.csqf.zx.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期: 2023年8月01日
 * 时间: 8:14
 * 作者: XinForever
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public List<FoodVO> foodList() {
      List<FoodDO> list = foodMapper.foodList();
      List<FoodVO> result = convert(list);
      return result;
    }

    @Override
    public void updateFood(Integer fid, FoodVO foodVO) {
        FoodDO result = convert(foodVO);
        foodMapper.updateFood(fid, foodVO);
    }

    @Override
    public void addFood(FoodVO foodVO) {
        FoodDO result = convert(foodVO);
        foodMapper.addFood(result);
    }

    @Override
    public void deleteFood(Integer fid) {
        foodMapper.deleteFood(fid);
    }

    public List<FoodVO> convert(List<FoodDO> list) {
        List<FoodVO> result = new ArrayList<>();

        list.forEach(fdo->{
            result.add(convert(fdo));
        });
        return result;
    }

    public static FoodVO convert(FoodDO item) {
        if (item == null) {
            return null;
        }
        FoodVO result = new FoodVO();
        result.setFid(item.getFid());
        result.setFname(item.getFname());
        result.setFprice(item.getFprice());
        result.setFcreated(item.getFcreated());
        result.setTid(item.getTid());
        result.setTypename(item.getTypeDO().getTname());
        return result;
    }

    public static FoodDO convert(FoodVO item) {
        if (item == null) {
            return null;
        }
        FoodDO result = new FoodDO();
        result.setFname(item.getFname());
        result.setFprice(item.getFprice());
        result.setFcreated(item.getFcreated());
        result.setTid(item.getTid());
        return result;
    }

}
