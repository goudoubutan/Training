package com.csqf.zx.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * @author makejava
 * @since 2023-07-29 09:11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelephoneDO implements Serializable {
    private static final long serialVersionUID = 624803516197297631L;

    private Integer id;

    private String tel;

    private Integer backid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    private UserBackDO userBackDO;
}

