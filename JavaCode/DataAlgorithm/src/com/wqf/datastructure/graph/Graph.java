package com.wqf.datastructure.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Graph {

    //存放顶点的集合
    private ArrayList<String> vertex;
    //存放边的领接矩阵
    private int[][] edges;
    //存放边的数目
    private int edgesNum;
    //定义数组表示顶点是否被访问过
    private boolean[] isVisited;

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        String[] vertexStr = {"A", "B", "C", "D", "E"};
        for (String str : vertexStr) {
            graph.add(str);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示领接矩阵
//        graph.display();
        //进行深度优先搜索
//        graph.DFS();
        //进行广度优先搜索
//        graph.BFS();
    }

    public void BFS() {
        for (int i = 0; i < vertex.size(); i++) {
            if (!isVisited[i]) {
                BFS(isVisited, i);
            }
        }
    }

    /**
     * 进行广度优先搜索
     * @param isVisited 判断顶点是否访问过的数组
     * @param index 从当前索引进行搜索
     */
    private void BFS(boolean[] isVisited, int index) {
        //创建队列
        LinkedList<Integer> vertexes = new LinkedList<>();
        //输出当前顶点
        System.out.print(vertex.get(index) + " ");
        //标记当前顶点为已访问
        isVisited[index] = true;
        //将当前顶点入队列
        vertexes.addLast(index);
        //保存当前顶点的领接顶点
        int next = 0;
        //保存队列的头顶点索引
        int head = 0;
        while (!vertexes.isEmpty()) {
            head = vertexes.removeFirst();
            next = getLeadVertex(head);
            while (next != -1) {
                //判断是否访问过
                if (!isVisited[next]) {
                    System.out.print(vertex.get(next));
                    //入队列
                    vertexes.addLast(next);
                    //标记已访问
                    isVisited[next] = true;
                } else {
                    //已经访问过了
                    next = getNextLeadVertex(index, next);
                }
            }
        }
    }

    /**
     * 对所有顶点进行深度优先搜索
     */
    public void DFS() {
        for (int i = 0; i < vertex.size(); i++) {
            if (!isVisited[i]) {
                //如果当前顶点没有被访问过,就进行深度优先遍历
                DFS(isVisited, i);
            }
        }
    }
    /**
     * 实现以某个顶点进行的深度优先遍历
     * @param isVisited 判断顶点是否被访问过的数组
     * @param index 顶点的索引
     */
    private void DFS(boolean[] isVisited, int index) {

        System.out.print(vertex.get(index) + " ");
        //标记已访问
        isVisited[index] = true;
        //找到index的领结顶点
        int next = getLeadVertex(index);
        //判断是否被访问过
        while (next != -1) {
            if (!isVisited[next]) {
                //下一个结点没有被访问过
                DFS(isVisited, next);
            } else {
                next = getNextLeadVertex(index, next);
            }
        }
    }

    //返回索引为index的顶点的第一个领接顶点
    public int getLeadVertex(int index) {
        for (int i = 0; i < vertex.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        //没有就返回-1
        return -1;
    }

    /**
     * 根据v1来寻找v2的下一个领接顶点
     * @param v1 前一个顶点的索引
     * @param v2 v1顶点的领接顶点
     * @return 寻找的顶点的索引
     */
    public int getNextLeadVertex(int v1, int v2) {
        for (int i = v2 + 1; i < vertex.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public Graph(int n) {
        vertex = new ArrayList<String>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }
    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgesNum++;
    }
    //得到结点的个数
    public int getVertexSize() {
        return vertex.size();
    }
    //添加结点
    public void add(String vertex) {
        this.vertex.add(vertex);
    }
    //得到边的个数
    public int getEdgesNum() {
        return edgesNum;
    }
    //得到索引对应的顶点
    public String getVertex(int index) {
        return vertex.get(index);
    }
    //返回两个结点的边的权值
    public int getWeightOfEdge(int v1, int v2) {
        return edges[v1][v2];
    }
    //显示领接矩阵
    public void display() {
        for (int[] weight : this.edges) {
            for (int value : weight) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
