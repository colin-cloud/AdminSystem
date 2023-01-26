package com.colin.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.colin.springboot.entity.User;
import com.colin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
//        return userService.getAllUsers();
        //mybatis-plus提供的方法
        return userService.list();
    }

    @PostMapping
    public Integer add(@RequestBody User user) {
        //mybatis实现方式
//        return userService.add(user);
        //mybatis-plus实现方式
        if (userService.saveUser(user)) {
            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
//        return userService.delete(id);
        //mybatis-plus实现方式
        if (userService.removeById(id)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 功能：批量删除
     * @param ids 需要删除的id
     * @return 1：成功删除；0：删除失败
     */
    @PostMapping("/del/batch")
    public Integer deleteBatch(@RequestBody List<Integer> ids) {
        if (userService.removeBatchByIds(ids)) {
            return 1;
        } else {
            return 0;
        }
    }

    /* 分页查询 mybatis方式
        @GetMapping("/page")
        public Map<String, Object> getUsers(@RequestParam Integer pageNum,
                                            @RequestParam Integer pageSize,
                                            @RequestParam String username,
                                            @RequestParam String address) {
            //计算当前页码的首位索引
            pageNum = (pageNum - 1) * pageSize;
            //模糊查询
            username = "%" + username + "%";
            address = "%" + address + "%";
            Integer total = userService.getTotal();
            Map<String, Object> res = new HashMap<String, Object>();
            res.put("total", total);
            res.put("data", userService.getUsersByPage(pageNum, pageSize, username, address));
            return res;
        }
     */

    /**
     *
     * @param pageNum 当前页码
     * @param pageSize 一页显示的条数
     * @param username 根据用户名进行模糊查询
     * @param address 根据地址进行模糊查询
     * @return IPage
     */
    @GetMapping("/page")
    public IPage<User> getUsers(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(required = false) String username,
                                        @RequestParam(required = false) String address) {
        IPage<User> page = new Page<User>(pageNum, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", username);
        wrapper.like("address", address);
        return userService.page(page, wrapper);
    }
}
