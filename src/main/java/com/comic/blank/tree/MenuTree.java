package com.comic.blank.tree;

import com.google.common.collect.Lists;

import java.util.List;

public class MenuTree {

    private List<Menu> menuList;

    public MenuTree(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // 建立树形结构
    public List<Menu> buildTree() {
        List<Menu> treeMenu = Lists.newLinkedList();
        for (Menu menuNode : getRootNode()) {
            buildChilTree(menuNode);
            treeMenu.add(menuNode);
        }
        return treeMenu;
    }

    // 递归，建立子树形结构
    private Menu buildChilTree(Menu node) {
        List<Menu> chilMenus = Lists.newLinkedList();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentId().equals(node.getId())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        node.setChildren(chilMenus);
        return node;
    }

    // 获取根节点
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists = Lists.newLinkedList();
        for (Menu menuNode: menuList) {
            if (menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

}
