/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.GroupUser.api;

import com.vn.hkt.core.GroupUser;
import java.util.List;

/**
 *
 * @author duong
 */
public interface IGroupUser {
     public boolean insertGroupUser(GroupUser group);

    public boolean updateGroupUser(GroupUser group);

    public boolean deleteGroupUser(GroupUser group);

    public List<GroupUser> getAllGroupUser();

    public GroupUser getGroupUserByID(String id);

    public List<GroupUser> filterGroupUserByID(String id);

    public List<GroupUser> filterGroupUserByName(String name);
}
