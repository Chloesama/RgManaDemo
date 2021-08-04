package com.chloe.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hsh
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Rgmana {

    private static final long serialVersionUID = 1L;

    @TableId("t1")
    private String t1;

    @TableField("t2")
    private String t2;

    @TableField("t3")
    private String t3;

}
