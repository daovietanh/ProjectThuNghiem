/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.core;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author home
 */
@Entity
public class GroupUser {

    @Id
    private String groupID;
    private String groupName;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public GroupUser(String groupID, String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return groupName;
    }

    public GroupUser() {
    }
}
