package com.csqf.zx.service;

import com.csqf.zx.VO.TelephoneVO;

import java.util.List;

/**
 * 日期: 20237月29
 * 作者: XinForever
 */
public interface BackService {
    List<TelephoneVO> backList();

    void updateBack(Integer id, TelephoneVO telephoneVO);

    void deleteBack(Integer id);

    void addBack(TelephoneVO telephoneVO);
}
