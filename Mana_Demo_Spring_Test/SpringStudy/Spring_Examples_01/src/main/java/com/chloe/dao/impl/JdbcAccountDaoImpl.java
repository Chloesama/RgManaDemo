package com.chloe.dao.impl;

import com.alibaba.druid.util.DruidWebUtils;
import com.chloe.dao.AccountDao;
import com.chloe.pojo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName JdbkAccountDaoImpl
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/22 20:33
 * @Version 1.0
 **/
public class JdbcAccountDaoImpl implements AccountDao {
    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        Connection con = null;
        String sql = "select * from account where cardNo = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while (resultSet.next()){
            account.setCardNo(resultSet.getString("cardNo"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getInt("money"));
        }
        resultSet.close();
        preparedStatement.close();
        con.close();

        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {
        Connection con = null;
        String sql = "update account set money = ? where cardNo = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,account.getMoney());
        preparedStatement.setString(2,account.getCardNo());
        int i = preparedStatement.executeUpdate();

        preparedStatement.close();
        con.close();
        return 0;
    }
}
