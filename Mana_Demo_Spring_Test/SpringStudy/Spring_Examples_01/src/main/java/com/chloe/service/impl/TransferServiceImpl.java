package com.chloe.service.impl;

import com.chloe.dao.AccountDao;
import com.chloe.dao.impl.JdbcAccountDaoImpl;
import com.chloe.pojo.Account;
import com.chloe.service.TransferService;

/**
 * @ClassName TransferServiceImpl
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 20:30
 * @Version 1.0
 **/
public class TransferServiceImpl implements TransferService {

    private AccountDao accountDao = new JdbcAccountDaoImpl();

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account form = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        form.setMoney(form.getMoney()-money);
        to.setMoney(to.getMoney()+money);

        accountDao.updateAccountByCardNo(form);
        accountDao.updateAccountByCardNo(to);
    }
}
