package com.csqf.zx.service.impl;

import com.csqf.zx.DO.TelephoneDO;
import com.csqf.zx.DO.UserBackDO;
import com.csqf.zx.VO.TelephoneVO;
import com.csqf.zx.mapper.BackMapper;
import com.csqf.zx.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期: 20237月29
 * 作者: XinForever
 */
@Service
public class BackServiceImpl implements BackService {

    @Autowired
    BackMapper backMapper;

    @Override
    public List<TelephoneVO> backList() {
      List<TelephoneDO> list = backMapper.backList();

      List<TelephoneVO> result = convert(list);

      return result;
    }

    @Override
    public void updateBack(Integer id, TelephoneVO telephoneVO) {
        TelephoneDO result = convert(telephoneVO);

        backMapper.updateBack(id,result);
    }

    @Override
    public void deleteBack(Integer id) {
        backMapper.deleteBack(id);
    }

    @Override
    public void addBack(TelephoneVO telephoneVO) {
        TelephoneDO result = convert(telephoneVO);

        backMapper.addBack(result);
    }

    public List<TelephoneVO> convert(List<TelephoneDO> list){
        List<TelephoneVO> result = new ArrayList<TelephoneVO>();

        list.forEach(item->{
            result.add(convert(item));
        });
        return result;
    }

    public static TelephoneVO convert(TelephoneDO item) {
        if (item == null) {
            return null;
        }
        TelephoneVO result = new TelephoneVO();
        result.setId(item.getId());
        result.setTel(item.getTel());
        result.setBackid(item.getBackid());
        result.setCreated(item.getCreated());
        result.setContent(item.getUserBackDO().getContent());
        return result;
    }

    public static TelephoneDO convert(TelephoneVO item) {
        if (item == null) {
            return null;
        }
        TelephoneDO result = new TelephoneDO();
        result.setTel(item.getTel());
        result.setBackid(item.getBackid());
        result.setCreated(item.getCreated());
        return result;
    }
}
