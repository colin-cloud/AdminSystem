package com.wqf.algorithm.greedy;

import java.util.*;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Greedy {

    public static void main(String[] args) {

        Map<String, HashSet<String>> broadcast = new HashMap<>();
        HashSet<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        HashSet<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        HashSet<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        HashSet<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");
        HashSet<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");

        broadcast.put("K1", k1);
        broadcast.put("K2", k2);
        broadcast.put("K3", k3);
        broadcast.put("K4", k4);
        broadcast.put("K5", k5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("深圳");

        System.out.println(getGreedyMethod(broadcast, allAreas));
    }

    public static List<String> getGreedyMethod(Map<String, HashSet<String>> broadcast, HashSet<String> allAreas) {
        //定义一个覆盖未覆盖地区的交集
        HashSet<String> set = new HashSet<>();
        List<String> selects = new ArrayList<>();
        //定义字符串用来保存每次比较中最大交集的一个电台
        String maxKey;
        while (allAreas.size() != 0) {
            //每次需要清空
            maxKey = null;
            for (String str : broadcast.keySet()) {
                //清空
                set.clear();
                //取出一个电台
                HashSet<String> area = broadcast.get(str);
                //添加到临时数组
                set.addAll(area);
                //得到交集
                set.retainAll(allAreas);
                if (set.size() > 0 && (maxKey == null || set.size() > broadcast.get(maxKey).size())) {
                    maxKey = str;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
            }
        }
        return selects;
    }
}
