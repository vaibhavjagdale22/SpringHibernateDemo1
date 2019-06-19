package com.prj.servicesimpl;

import com.prj.daos.UserDao;
import com.prj.entities.UserInfo;
import com.prj.services.LoginServices;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginServices {
    @Autowired(required = true)
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public boolean addUser(UserInfo userInfo) {
        try {
            if(userDao.addUser(userInfo)!=null)
            return true;
        }catch(HibernateException ex){ex.getMessage();}
            return false;
    }
}
