package com.manager.system.service;

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


}
