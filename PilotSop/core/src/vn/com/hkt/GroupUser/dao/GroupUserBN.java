/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.GroupUser.dao;

import com.vn.hkt.core.GroupUser;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.GroupUser.api.IGroupUser;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IGroupUser.class)
public class GroupUserBN implements IGroupUser {

    private IGenericAPI mydao;

    public GroupUserBN() {
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertGroupUser(GroupUser group) {
        if (mydao.insertData(group)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateGroupUser(GroupUser group) {
        if (mydao.updateData(group)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGroupUser(GroupUser group) {
        if (mydao.deleteData(GroupUser.class, group.getGroupID())) {

            return true;
        }
        return false;
    }

    @Override
    public List<GroupUser> getAllGroupUser() {
        List<GroupUser> list = new ArrayList<GroupUser>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(GroupUser.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((GroupUser) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public GroupUser getGroupUserByID(String id) {
        return (GroupUser) mydao.getByID(GroupUser.class, id);
    }

    @Override
    public List<GroupUser> filterGroupUserByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<GroupUser> result = new ArrayList<GroupUser>();
        list = mydao.filterByCondition(GroupUser.class, "groupID", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((GroupUser) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<GroupUser> filterGroupUserByName(String name) {
        List<Object> list = new ArrayList<Object>();
        List<GroupUser> result = new ArrayList<GroupUser>();
        list = mydao.filterByCondition(GroupUser.class, "groupName", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((GroupUser) list.get(i));
            }
        }
        return result;
    }
}
