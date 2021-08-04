package com.chloe.dao;

import com.chloe.pojo.Account;

/**
 * @ClassName AccountDao
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 20:32
 * @Version 1.0
 **/
public interface AccountDao {
    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}
