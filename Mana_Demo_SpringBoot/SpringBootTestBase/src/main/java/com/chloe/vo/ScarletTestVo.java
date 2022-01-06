package com.chloe.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScarletTestVo
 * @Description TODO
 * @Author RgMana
 * @Date 2022/1/6 15:37
 * @Version 1.0
 **/
@Data
@Component
@Scope("prototype")
@AllArgsConstructor
public class ScarletTestVo {
    String str1;
    String str2;
}
