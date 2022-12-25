package com.wqf.chinesebuid.service;

import com.wqf.chinesebuid.dao.BillDAO;
import com.wqf.chinesebuid.dao.MultiTableDAO;
import com.wqf.chinesebuid.domain.Bill;
import com.wqf.chinesebuid.domain.DinningTable;
import com.wqf.chinesebuid.domain.Menu;
import com.wqf.chinesebuid.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @author 小白学java
 * @version 1.0
 */
public class BillService {
    //定义一个BillDAO对象
    private BillDAO billDAO = new BillDAO();
    //定义一个MenuService对象
    private MenuService menuService = new MenuService();
    //定义一个DinningTableService对象
    private DinningTableService dinningTableService = new DinningTableService();
    //定义一个MultiTableDAO对象
    private MultiTableDAO multiTableDAO = new MultiTableDAO();
    //编写方法得到账单集合
//    public List<Bill> getBills() {
//        String sql = "select * from bill";
//        List<Bill> bills = billDAO.queryMulti(sql, Bill.class);
//        return bills;
//    }
    //编写方法可以返回菜品名的集合
        public List<MultiTableBean> getMultiTableBeans() {
        String sql = "select bill.*, name from bill, menu where bill.menuId = menu.id";
        List<MultiTableBean> multiTableBeans = multiTableDAO.queryMulti(sql, MultiTableBean.class);
        return multiTableBeans;
    }
    //编写方法执行添加账单的sql语句
    public boolean insertBill(int menuId, int nums, int tableId) {
        String sql = "insert into bill values(null, ?, ?, ?, now(), ?, '未结账', ?)";
        //得到对应菜品的金额
        Menu spMenu = menuService.getSpMenu(menuId);
        int update = billDAO.update(sql, UUID.randomUUID().toString().substring(0, 20),
                menuId, nums, spMenu.getPrice() * nums, tableId);
        return update > 0;
    }
    //编写方法改变账单的状态
    public boolean updateStatusToInvoicing(int tableId, String invoicing) {
        String sql = "update bill set status = ? where tableId = ?";
        int update = billDAO.update(sql, invoicing, tableId);
        return update > 0;
    }
    //编写方法判断张单是否需要结账
    public boolean isInvoice(int tableId) {
        //找到该餐桌
        String sql = "select * from bill where tableId = ?";
        if (!billDAO.querySingle(sql, Bill.class, tableId).getStatus().equals("未结账")) {
            return false;
        }
        return true;
    }
}
