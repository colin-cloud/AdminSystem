package com.wqf.chinesebuid.view;

import com.wqf.chinesebuid.domain.*;
import com.wqf.chinesebuid.service.BillService;
import com.wqf.chinesebuid.service.DinningTableService;
import com.wqf.chinesebuid.service.EmployeeService;
import com.wqf.chinesebuid.service.MenuService;

import java.util.List;
import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 * 主界面
 */
public class ChinaBuildView {
    private Scanner scanner = new Scanner(System.in);
    private boolean loop = true;
    //定义一个员工服务对象
    private EmployeeService employeeService = new EmployeeService();
    //定义一个餐桌服务对象
    private DinningTableService dinningTableService = new DinningTableService();
    //定义一个菜品服务对象
    private MenuService menuService = new MenuService();
    //定义一个账单服务对象
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new ChinaBuildView().mainView();
    }
    //显示主菜单
    public void mainView() {
        while (loop) {
            System.out.println("==============满汉楼=================");
            System.out.println("\t\t\t1. 登录满汉楼");
            System.out.println("\t\t\t2. 退出满汉楼");
            System.out.print("请输入你的选择: ");
            String choose = scanner.next();
            switch (choose) {
                case "1" :
                    //进入二级菜单
                    System.out.print("请输入员工号: ");
                    String empId = scanner.next();
                    System.out.print("请输入密码: ");
                    String empPassword = scanner.next();
                    //进入数据库进行判断
                    //将登录信息单独列出一张表，登陆成功自动生成一个员工信息
                    Employee employee = employeeService.getEmployee(empId, empPassword);
                    if (employee != null) {
                        //进入二级菜单
                        secondView();
                    } else {
                        System.out.println("你输入的账号密码错误~~~~");
                    }
                    break;
                case "2" :
                    loop = false;
                    System.out.println("退出满汉楼~");
                    break;
                default :
                    System.out.println("输入错误,请重新输入~");
                    break;
            }
        }
    }
    //二级菜单
    public void secondView() {
        while (loop) {
            System.out.println("==============满汉楼二级菜单=================");
            System.out.println("\t\t\t1. 显示菜单状态");
            System.out.println("\t\t\t2. 预定餐桌");
            System.out.println("\t\t\t3. 显示所有菜品");
            System.out.println("\t\t\t4. 点餐服务");
            System.out.println("\t\t\t5. 查看账单");
            System.out.println("\t\t\t6. 结账");
            System.out.println("\t\t\t9. 退出满汉楼");
            System.out.print("请输入你的选择: ");
            String choose = scanner.next();
            switch (choose) {
                case "1" :
                    //显示菜单状态
                    displayTableStatus();
                    break;
                case "2" :
                    //预定餐桌
                    reserveTable();
                    break;
                case "3" :
                    //显示所有菜品
                    displayMenu();
                    break;
                case "4" :
                    //点餐服务
                    orderMeal();
                    break;
                case "5" :
                    //查看账单
                    displayBills();
                    break;
                case "6" :
                    //结账
                    invoicingBill();
                    break;
                case "9" :
                    //退出满汉楼
                    loop = false;
                    System.out.println("退出满汉楼~");
                    break;
                default :
                    System.out.println("输入错误,请重新输入~~");
                    break;
            }
        }
    }
    //显示餐桌状态
    public void displayTableStatus() {
        System.out.println("餐桌ID\t\t餐桌状态");
        List<DinningTable> dinningTables = dinningTableService.getDinningTables();
        for (DinningTable dinningTable : dinningTables) {
            System.out.println(dinningTable);
        }
    }
    //进行定餐桌
    public void reserveTable() {
        System.out.print("请输入想要预定的餐桌号(-1退出): ");
        String idStr = scanner.next();
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println("输入错误~");
            return;
        }
        if (id == -1) {
            System.out.println("退出预定~");
            return;
        }
        if (!dinningTableService.isExitAndNull(id)) {
            System.out.println("餐桌无法预定~");
            return;
        }
        System.out.print("确认是否预定(Y/Other): ");
        String choose = scanner.next();
        if (!choose.equals("Y") && !choose.equals("y")) {
            System.out.println("取消预订~");
            return;
        }
        System.out.print("预定人姓名: ");
        String name = scanner.next();
        System.out.print("预订人电话: ");
        String telephone = scanner.next();
        //将餐桌的状态改变
        boolean updateTableStatus = dinningTableService.updateTableStatus(id, name, telephone);
        if (updateTableStatus) {
            System.out.println("预定成功~");
        } else {
            System.out.println("预定失败~");
        }
    }
    //显示所有菜品
    public void displayMenu() {
        System.out.println("==============本店有如下菜品=============");
        System.out.println("菜品编号" + "\t\t" + "菜品名称" + "\t\t" + "类别" + "\t\t" + "价格");
        //得到菜单集合
        List<Menu> menus = menuService.getMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    //进行点餐服务
    public void orderMeal() {
        System.out.print("请输入你所在餐桌编号: ");
        int id = scanner.nextInt();
        //进行餐桌校验
        DinningTable dinningTable = dinningTableService.getDinningTable(id);
        if (dinningTable == null) {
            System.out.println("餐桌不存在~");
            return;
        }
        if (!dinningTableService.isExitAndNull(id)) {
            System.out.println("餐桌无法点餐~");
            return;
        }
        System.out.print("请输入菜品编号: ");
        int menuId = scanner.nextInt();
        //进行菜品校验
        Menu spMenu = menuService.getSpMenu(menuId);
        if (spMenu == null) {
            System.out.println("菜品不存在~");
            return;
        }
        System.out.print("请输入该菜品的数量: ");;
        int menuNums = scanner.nextInt();
        System.out.print("请确定是否点餐(Y/Other): ");
        String choose = scanner.next();
        if (choose.equals("y") && choose.equals("Y")) {
            System.out.println("取消订餐~");
            return;
        }
        //修改餐桌状态
        boolean bool = dinningTableService.updateTableStatusDinning(id);
        if (bool) {
            System.out.println("订餐成功~");
            //成功了就生成一份账单
            boolean isSuccess = billService.insertBill(menuId, menuNums, id);
            if (isSuccess) {
                System.out.println("账单生成成功~");
            } else {
                System.out.println("账单生成失败~");
            }
        } else {
            System.out.println("订餐失败~");
        }
    }
    //查看账单
    public void displayBills() {
//        List<Bill> bills = billService.getBills();
        List<MultiTableBean> multiTableBeans = billService.getMultiTableBeans();
        System.out.println("编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t状态\t\t菜品名");
        for (MultiTableBean multiTableBean : multiTableBeans) {
            System.out.println(multiTableBean);
        }
    }
    public void invoicingBill() {
        System.out.print("请选择要结账的餐桌编号(-1退出): ");
        int tableId = scanner.nextInt();
        if (tableId == -1) {
            System.out.println("取消结账~");
            return;
        }
        //进行餐桌校验
        if (dinningTableService.getDinningTable(tableId) == null) {
            System.out.println("餐桌不存在~");
            return;
        }
        //判断是否需要结账
        boolean bool = billService.isInvoice(tableId);
        if (!bool) {
            System.out.println("该餐桌不需要结账~");
            return;
        }
        System.out.print("请选择结账的方式(现金/支付宝/微信): ");
        String invoicing = scanner.next();
        System.out.print("请确认是否结账(Y/Other): ");
        String choose = scanner.next();
        if (!choose.equals("y") && !choose.equals("Y")) {
            System.out.println("取消结账~");
            return;
        }
        //对餐桌的状态进行改变
        boolean bool1 = dinningTableService.clearTable(tableId);
        if (bool1) {
            System.out.println("餐桌改变信息~");
            boolean bool2 = billService.updateStatusToInvoicing(tableId, invoicing);
            if (bool2) {
                System.out.println("结账成功~");
            } else {
                System.out.println("结账失败~");
            }
        } else {
            System.out.println("餐桌状态改变失败~");
        }
        //对账单进行相应改变
    }
}
