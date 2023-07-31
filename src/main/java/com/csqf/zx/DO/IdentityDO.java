package com.csqf.zx.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author makejava
 * @since 2023-07-31 08:15:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentityDO implements Serializable {
    private static final long serialVersionUID = -39496725179073178L;

    private Integer typeid;

    private String typename;

}

