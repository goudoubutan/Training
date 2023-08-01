package com.csqf.zx.mapper;

import com.csqf.zx.DO.BonusDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日期: 2023年7月31日
 * 时间: 8:19
 * 作者: XinForever
 */
public interface BonusMapper {
    List<BonusDO> bonusList();

    void updateBonus(Integer id ,@Param("bonus") BonusDO bonusDO);

    void addBonus(@Param("bonus") BonusDO bonusDO);

    void deleteBonus(Integer id);
}
