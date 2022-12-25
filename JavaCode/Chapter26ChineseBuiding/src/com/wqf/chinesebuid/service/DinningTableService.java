package com.wqf.chinesebuid.service;

import com.wqf.chinesebuid.dao.DinningTableDAO;
import com.wqf.chinesebuid.domain.DinningTable;

import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
public class DinningTableService {//业务层
    //定义一个DinningTableDAO对象
    private DinningTableDAO dinningTableDAO = new DinningTableDAO();

    //编写方法返回信息的集合
    public List<DinningTable> getDinningTables() {
        String sql = "select id, status from dinningTable";
        List<DinningTable> dinningTables = dinningTableDAO.queryMulti(sql, DinningTable.class);
        return dinningTables;
    }
    //寻找特定餐桌
    public DinningTable getDinningTable(int id) {
        String sql = "select * from dinningTable where id = ?";
        DinningTable dinningTable = dinningTableDAO.querySingle(sql, DinningTable.class, id);
        return dinningTable;
    }
    //编写方法进行特定餐桌的校验
    public boolean isExitAndNull(int id) {
        String sql = "select * from dinningTable where id = ?";
        DinningTable dinningTable = dinningTableDAO.querySingle(sql, DinningTable.class, id);
        //判断返回对象是否为null
        if (dinningTable == null) {
            return false;
        }
        if (!dinningTable.getStatus().equals("空")) {
            return false;
        }
        return true;
    }
    //编写方法改变餐桌状态为已预订
    public boolean updateTableStatus(int id, String name, String telephone) {
        String sql = "update dinningTable set orderName = ?, orderTel = ?, status = '已预订' where id = ?";
        int update = dinningTableDAO.update(sql, name, telephone, id);
        if (update <= 0) {
            return false;
        }
        return true;
    }
    //编写方法改变餐桌状态为正在就餐
    public boolean updateTableStatusDinning(int id) {
        String sql = "update dinningTable set status = '就餐中' where id = ?";
        int update = dinningTableDAO.update(sql, id);
        return update > 0;
    }
    //编写方法改变餐桌状态为空
    public boolean updateTableStatusNull(int id) {
        String sql = "update dinningTable set status = '空' where id = ?";
        int update = dinningTableDAO.update(sql, id);
        return update > 0;
    }
    //将餐桌的信息进行清空
    public boolean clearTable(int tableId) {
        String sql = "update dinningTable set status = '空', orderName = '', orderTel = ''where id = ?";
        int update = dinningTableDAO.update(sql, tableId);
        return update > 0;
    }
}
