package mana.service;

import mana.dao.UserDao;
import mana.dao.UserDaoImpl;
import mana.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoMysqlImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
