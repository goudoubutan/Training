package com.csqf.zx.controller;

import com.csqf.zx.VO.BonusVO;
import com.csqf.zx.restult.ResponseResult;
import com.csqf.zx.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日期: 2023年7月31日
 * 时间: 8:18
 * 作者: XinForever
 */
@CrossOrigin
@RestController
@RequestMapping("/bonus")
public class BonusController {

    @Autowired
    BonusService bonusService;

    @GetMapping
    public ResponseResult bonusList() {
        ResponseResult result = ResponseResult.SUCCESS();

        List<BonusVO> list = bonusService.bonusList();
        result.setData(list);

        return result;
    }

    @PutMapping("{id}")
    public ResponseResult updateBonus(@PathVariable Integer id, @RequestBody BonusVO bonusVO) {
        ResponseResult result = ResponseResult.SUCCESS();

        bonusService.updateBonus(id, bonusVO);

        return result;
    }

}
