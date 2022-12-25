package com.wqf.chinesebuid.service;

import com.wqf.chinesebuid.dao.MenuDAO;
import com.wqf.chinesebuid.domain.Menu;

import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
public class MenuService {
    //定义MenuDAO对象
    private MenuDAO menuDAO = new MenuDAO();

    //编写方法返回菜单
    public List<Menu> getMenu() {
        String sql = "select * from menu";
        List<Menu> menus = menuDAO.queryMulti(sql, Menu.class);
        return menus;
    }
    //编写方法返回特定菜品
    public Menu getSpMenu(int id) {
        String sql = "select * from menu where id = ?";
        Menu menu = menuDAO.querySingle(sql, Menu.class, id);
        return menu;
    }
}
