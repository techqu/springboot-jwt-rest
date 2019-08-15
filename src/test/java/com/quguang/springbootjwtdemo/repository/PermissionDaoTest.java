package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.Tester;
import com.quguang.springbootjwtdemo.constant.SystemConstant;
import com.quguang.springbootjwtdemo.entity.Permission;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class PermissionDaoTest extends Tester {
    @Autowired
    private PermissionDao permissionDao;
    @Test
    public void findByTypeAndPid() {
        List<Permission> byTypeAndPid = permissionDao.findByTypeAndPid(SystemConstant.PERMISSION_API_TYPE_ID, "1");
        System.out.println(byTypeAndPid.size());
    }
}