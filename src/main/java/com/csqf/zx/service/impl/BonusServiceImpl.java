package com.csqf.zx.service.impl;

import com.csqf.zx.DO.BonusDO;
import com.csqf.zx.VO.BonusVO;
import com.csqf.zx.mapper.BonusMapper;
import com.csqf.zx.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期: 2023年7月31日
 * 时间: 8:19
 * 作者: XinForever
 */
@Service
public class BonusServiceImpl implements BonusService {

    @Autowired
    BonusMapper bonusMapper;

    @Override
    public List<BonusVO> bonusList() {
        List<BonusDO> list = bonusMapper.bonusList();
        List<BonusVO> result = convert(list);

        return result;
    }

    @Override
    public void updateBonus(Integer id, BonusVO bonusVO) {
        BonusDO bonusDO = convert(bonusVO);
        bonusMapper.updateBonus(id,bonusDO);
    }

    public List<BonusVO> convert(List<BonusDO> list) {
        List<BonusVO> result = new ArrayList<BonusVO>();

        list.forEach(item -> {
            result.add(convert(item));
        });
        return result;
    }

    public static BonusVO convert(BonusDO item) {
        if (item == null) {
            return null;
        }
        BonusVO result = new BonusVO();
        result.setId(item.getId());
        result.setName(item.getName());
        result.setMoney(item.getMoney());
        result.setTypeid(item.getTypeid());
        result.setCreated(item.getCreated());
        result.setTypename(item.getIdentityDO().getTypename());
        return result;
    }

    public static BonusDO convert(BonusVO item) {
        if (item == null) {
            return null;
        }
        BonusDO result = new BonusDO();
        result.setName(item.getName());
        result.setMoney(item.getMoney());
        result.setTypeid(item.getTypeid());
        result.setCreated(item.getCreated());
        return result;
    }

}
