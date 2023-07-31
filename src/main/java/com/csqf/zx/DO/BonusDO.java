package com.csqf.zx.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * @author makejava
 * @since 2023-07-31 08:15:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BonusDO implements Serializable {
    private static final long serialVersionUID = -63403066011269043L;

    private Integer id;

    private String name;

    private String money;

    private Integer typeid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    private IdentityDO identityDO;
}

