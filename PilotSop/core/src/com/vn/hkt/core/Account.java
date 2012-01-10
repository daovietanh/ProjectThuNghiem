/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author home
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private int userID;
    private String username;
    private String password;
    private String personID;
    private String groupID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public Account(String username, String password, String personID, String groupID) {
        this.username = username;
        this.password = password;
        this.personID = personID;
        this.groupID = groupID;
    }

    public Account() {
    }
}
