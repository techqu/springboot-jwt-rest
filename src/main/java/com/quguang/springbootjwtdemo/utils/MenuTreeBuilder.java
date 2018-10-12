package com.quguang.springbootjwtdemo.utils;


import com.quguang.springbootjwtdemo.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 瞿广 on 2018/10/12 0012.
 */

public class MenuTreeBuilder {

    /**
     * 两层循环实现建树
     * @param Menus 传入的树节点列表
     * @return
     */
    public static List<Menu> bulid(List<Menu> Menus) {

        List<Menu> trees = new ArrayList<Menu>();

        for (Menu Menu : Menus) {

            if (Menu.getParentId()==null) {
                trees.add(Menu);
            }

            for (Menu it : Menus) {
                if (it.getParentId() == Menu.getId()) {
                    if (Menu.getChildren() == null) {
                        Menu.setChildren(new ArrayList<Menu>());
                    }
                    Menu.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     * @param Menus
     * @return
     */
    public static List<Menu> buildByRecursive(List<Menu> Menus) {
        List<Menu> trees = new ArrayList<Menu>();
        for (Menu Menu : Menus) {
            if (Menu.getParentId()==null) {
                trees.add(findChildren(Menu,Menus));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param Menus
     * @return
     */
    public static Menu findChildren(Menu Menu,List<Menu> Menus) {
        for (Menu it : Menus) {
            if(Menu.getId().equals(it.getParentId())) {
                if (Menu.getChildren() == null) {
                    Menu.setChildren(new ArrayList<Menu>());
                }
                Menu.getChildren().add(findChildren(it,Menus));
            }
        }
        return Menu;
    }





}