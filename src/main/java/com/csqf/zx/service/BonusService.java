package com.csqf.zx.service;

import com.csqf.zx.VO.BonusVO;

import java.util.List;

/**
 * 日期: 2023年7月31日
 * 时间: 8:19
 * 作者: XinForever
 */
public interface BonusService {
    List<BonusVO> bonusList();

    void updateBonus(Integer id, BonusVO bonusVO);
}
