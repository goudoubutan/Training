package com.csqf.zx.service.impl;

import com.csqf.zx.DO.TypeDO;
import com.csqf.zx.VO.TypeVO;
import com.csqf.zx.mapper.TypeMapper;
import com.csqf.zx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期: 2023年8月01日
 * 时间: 8:46
 * 作者: XinForever
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<TypeVO> getAllType() {
      List<TypeDO> list = typeMapper.getAllType();
      List<TypeVO> result = convert(list);
        return result;
    }

    public List<TypeVO> convert(List<TypeDO> list){
        List<TypeVO> result = new ArrayList<>();

        list.forEach(tdo->{
            result.add(convert(tdo));
        });
        return result;
    }

    public static TypeVO convert(TypeDO item) {
        if (item == null) {
            return null;
        }
        TypeVO result = new TypeVO();
        result.setTid(item.getTid());
        result.setTname(item.getTname());
        return result;
    }

}
