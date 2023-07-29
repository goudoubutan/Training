package com.csqf.zx.service.impl;

import com.csqf.zx.DO.UserBackDO;
import com.csqf.zx.VO.UserBackVO;
import com.csqf.zx.mapper.SatisfactionMapper;
import com.csqf.zx.service.SatisfactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期: 2023年7月29日
 * 时间: 10:34
 * 作者: XinForever
 */
@Service
public class SatisfactionServiceImpl implements SatisfactionService {

    @Autowired
    SatisfactionMapper satisfactionMapper;

    @Override
    public List<UserBackVO> satisfactionList() {
        List<UserBackDO> list = satisfactionMapper.satisfactionList();

        List<UserBackVO> result = convert(list);

        return result;
    }

    public List<UserBackVO> convert(List<UserBackDO> list){
        List<UserBackVO> result = new ArrayList<UserBackVO>();

        list.forEach(item->{
            result.add(convert(item));
        });
        return result;
    }

    public static UserBackVO convert(UserBackDO item) {
        if (item == null) {
            return null;
        }
        UserBackVO result = new UserBackVO();
        result.setId(item.getId());
        result.setContent(item.getContent());
        return result;
    }

}
