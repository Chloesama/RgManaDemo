package com.mana;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class log4jtest {
    private static final Logger logger = LoggerFactory.getLogger(log4jtest.class);
    /**
     * 测试数组栈
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println("sout结果" + list.toString());

        logger.debug("debug结果："+ list.toString());
        logger.trace("trace结果："+ list.toString());
        logger.error("error结果："+ list.toString());
        logger.warn("warn结果："+ list.toString());
        logger.info("info结果："+ list.toString());
    }
}
