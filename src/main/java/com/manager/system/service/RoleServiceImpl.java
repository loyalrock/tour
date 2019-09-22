package com.manager.system.service;

import com.manager.entry.common.UserUtil;
import com.manager.entry.system.Role;
import com.manager.system.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Role selectRoleByUserUid(String userUid) {
        return roleMapper.selectRoleByUserUid(userUid);
    }

    @Override
    public List<Role> selectRoleList() {
        return roleMapper.selectList();
    }

    @Override
    public int updateRole(Role role) {
        Role update = new Role();
        update.setSs02Id(role.getSs02Id());
        update.setUserRoleName(role.getUserRoleName());
        UserUtil.updateData(update);
        return roleMapper.updateByPrimaryKeySelective(update);
    }
}
