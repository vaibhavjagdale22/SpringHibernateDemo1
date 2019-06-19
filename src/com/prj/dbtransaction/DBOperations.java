package com.prj.dbtransaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBOperations {
    private Configuration config = null;
    private SessionFactory sessionFactory = null;
    private Transaction trx = null;

    public  Session getSession(){
        try {
            config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();
            return sessionFactory.openSession();
        }catch(Exception ex){ex.getMessage();}
        return null;
    }
    public Transaction beginTransactionOnCurrentSession(Session session){
        if(session!=null)
            return session.beginTransaction();
        return null;
    }
    public boolean closeSession(Session session){
        try {
            session.close();
        }catch(HibernateException ex){ex.getMessage();}
        return false;
    }
}
