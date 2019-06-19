package com.prj.daosimpl;

import com.prj.daos.UserDao;
import com.prj.dbtransaction.DBOperations;
import com.prj.entities.UserInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {
    @Autowired
    private DBOperations dbOperations;

    public void setDbOperations(DBOperations dbOperations){
        this.dbOperations = dbOperations;
    }
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        try {
            Session session = dbOperations.getSession();
            Transaction trx = dbOperations.beginTransactionOnCurrentSession(session);
            session.save(userInfo);
            trx.commit();
           if(dbOperations.closeSession(session))
               return userInfo;
        }catch(HibernateException ex){ex.getMessage();}
        return null;
    }
}
