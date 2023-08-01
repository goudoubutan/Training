package com.csqf.zx.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author makejava
 * @since 2023-08-01 08:10:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO implements Serializable {
    private static final long serialVersionUID = 768675957058984485L;

    private Integer fid;

    private String fname;

    private Double fprice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fcreated;

    private Integer tid;

    private String typename;
}

