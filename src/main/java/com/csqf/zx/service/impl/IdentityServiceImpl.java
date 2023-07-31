package com.csqf.zx.service.impl;

import com.csqf.zx.DO.IdentityDO;
import com.csqf.zx.VO.IdentityVO;
import com.csqf.zx.mapper.IdentityMapper;
import com.csqf.zx.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期: 2023年7月31日
 * 时间: 8:54
 * 作者: XinForever
 */
@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    IdentityMapper identityMapper;

    @Override
    public List<IdentityVO> identityList() {
        List<IdentityDO> list = identityMapper.identityList();

        List<IdentityVO> result = convert(list);

        return result;
    }

    public List<IdentityVO> convert(List<IdentityDO> list) {
        List<IdentityVO> result = new ArrayList<IdentityVO>();

        list.forEach(item -> {
            result.add(convert(item));
        });
        return result;
    }

    public static IdentityVO convert(IdentityDO item) {
        if (item == null) {
            return null;
        }
        IdentityVO result = new IdentityVO();
        result.setTypeid(item.getTypeid());
        result.setTypename(item.getTypename());
        return result;
    }

}
