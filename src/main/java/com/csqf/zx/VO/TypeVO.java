package com.csqf.zx.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author makejava
 * @since 2023-08-01 08:10:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeVO implements Serializable {
    private static final long serialVersionUID = -14431162170930999L;

    private Integer tid;

    private String tname;
}

