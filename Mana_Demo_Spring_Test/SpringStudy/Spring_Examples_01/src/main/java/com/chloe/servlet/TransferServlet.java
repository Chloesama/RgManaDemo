package com.chloe.servlet;

import com.chloe.service.TransferService;
import com.chloe.service.impl.TransferServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName TransferServlet
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 20:19
 * @Version 1.0
 **/
public class TransferServlet extends HttpServlet {
    private TransferService transferService = new TransferServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        doPost(req,res);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        req.setCharacterEncoding("UTF-8");

        String fromCardNo = req.getParameter("fromCardNo");
        String toCardNo = req.getParameter("toCardNo");
        String moneyStr = req.getParameter("money");
        int money = Integer.parseInt(moneyStr);


        transferService.transfer(fromCardNo,toCardNo,money);
    }
}
