package com.wqf.dao.test;

import com.wqf.dao.dao.ActorDAO;
import com.wqf.dao.dao.GoodsDAO;
import com.wqf.dao.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
public class TestDAO {
    //测试ActorDAO对actor表的操作
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        String sql = "select * from actor";
        List<Actor> list = actorDAO.queryMulti(sql, Actor.class, null);
        for (Actor actor : list) {
            System.out.println(actor);
        }
    }
    //测试对GoodsDAO对Goods表的操作
    @Test
    public void testGoodsDAO() {
        GoodsDAO goodsDAO = new GoodsDAO();
        String sql = "insert into goods values(null, ?, ?)";
        int update = goodsDAO.update(sql, "华为手机", 2000);
        System.out.println(update > 0 ? "成功" : "失败");
    }
}
