package com.prj.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "myuser")
@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "userinfoid_pk")
    private int userinfoid;

    
    @Column
    private String firstname;


    public UserInfo() {}
    //getters and setters
    public UserInfo(int id, String name){
        this.userinfoid = id;
        this.firstname = name;
    }
    public int getUserinfoid() {
        return userinfoid;
    }
    public void setUserid(int userinfoid) {
        this.userinfoid = userinfoid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
