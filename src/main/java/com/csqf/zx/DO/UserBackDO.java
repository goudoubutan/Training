package com.csqf.zx.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author makejava
 * @since 2023-07-29 09:12:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBackDO implements Serializable {
    private static final long serialVersionUID = 766021257060558000L;

    private Integer id;

    private String content;

}

