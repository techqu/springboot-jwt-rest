package com.quguang.springbootjwtdemo.utils;


import com.quguang.springbootjwtdemo.entity.PermissionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 瞿广 on 2018/10/12 0012.
 */

public class MenuTreeBuilder {

    /**
     * 两层循环实现建树
     * @param perMenus 传入的树节点列表
     * @return
     */
    public static List<PermissionMenu> bulid(List<PermissionMenu> perMenus) {

        List<PermissionMenu> trees = new ArrayList<PermissionMenu>();

        for (PermissionMenu PerMenu : perMenus) {

            if (PerMenu.getParentId()==null) {
                trees.add(PerMenu);
            }

            for (PermissionMenu it : perMenus) {
                if (PerMenu.getId().equals( it.getParentId() )) {
                    if (PerMenu.getChildren() == null) {
                        PerMenu.setChildren(new ArrayList<PermissionMenu>());
                    }
                    PerMenu.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     * @param perMenus
     * @return
     */
    public static List<PermissionMenu> buildByRecursive(List<PermissionMenu> perMenus) {
        List<PermissionMenu> trees = new ArrayList<PermissionMenu>();
        for (PermissionMenu PerMenu : perMenus) {
            if (PerMenu.getParentId()==null) {
                trees.add(findChildren(PerMenu, perMenus));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param perMenus
     * @return
     */
    public static PermissionMenu findChildren(PermissionMenu PerMenu, List<PermissionMenu> perMenus) {
        for (PermissionMenu it : perMenus) {
            if(PerMenu.getId().equals(it.getParentId())) {
                if (PerMenu.getChildren() == null) {
                    PerMenu.setChildren(new ArrayList<PermissionMenu>());
                }
                PerMenu.getChildren().add(findChildren(it, perMenus));
            }
        }
        return PerMenu;
    }





}