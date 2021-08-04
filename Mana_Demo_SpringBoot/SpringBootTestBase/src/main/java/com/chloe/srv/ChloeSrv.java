package com.chloe.srv;

import com.chloe.annotation.ThreadAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName ChloeSrv
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 14:59
 * @Version 1.0
 **/
@Service
@Slf4j
public class ChloeSrv {

    @ThreadAnnotation
    public void testChloe() {
        try{
            Thread.sleep(3000);
            log.info("ChloeSrv-testChloe");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
