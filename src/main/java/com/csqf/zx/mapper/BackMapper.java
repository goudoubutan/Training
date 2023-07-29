package com.csqf.zx.mapper;

import com.csqf.zx.DO.TelephoneDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日期: 20237月29
 * 作者: XinForever
 */
public interface BackMapper {
    List<TelephoneDO> backList();

    void updateBack(Integer id,@Param("result") TelephoneDO result);

    void deleteBack(Integer id);

    void addBack(@Param("result") TelephoneDO result);
}
