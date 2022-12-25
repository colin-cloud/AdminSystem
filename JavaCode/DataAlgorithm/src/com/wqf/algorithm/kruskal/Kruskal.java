package com.wqf.algorithm.kruskal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Kruskal {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexNum = vertexes.length;
        int[][] weight = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        Graph graph = new Graph(vertexNum);
        graph.creatGraph(vertexes, weight, vertexNum);
        kruskal(graph);
    }

    public static void kruskal(Graph graph) {
        //创建数组来保存对应顶点的终点
        int[] ends = new int[graph.vertexNum];
        //创建结果边集合
        ArrayList<EData> res = new ArrayList<>();
        //得到总共边的集合
        List<EData> edges = getEdgeList(graph);
        //对总边进行排序
        Collections.sort(edges);
        while (edges.size() != 0) {
            //取出最小权值的边
            EData edge = edges.remove(0);
            //得到最小边的头和尾索引
            int tailIndex = graph.getVertexIndex(edge.tail);
            int rearIndex = graph.getVertexIndex(edge.rear);
            //得到这两个顶点的终点
            int tailEnd = getEnd(ends, tailIndex);
            int rearEnd = getEnd(ends, rearIndex);
            if (tailEnd != rearEnd) {
                //设置头顶点的终点为尾顶点
                ends[tailIndex] = rearIndex;
                //将这条边放到结果集合中
                res.add(edge);
            }
        }
        System.out.println(res);
    }

    //得到index索引下的终点的索引
    public static int getEnd(int[] ends, int index) {
        while (ends[index] != 0) {
            index = ends[index];
        }
        return index;
    }
    //得到边的条数
    public static int getEdges(Graph graph) {
        int edges = 0;
        for (int i = 0; i < graph.vertexNum; i++) {
            for (int j = i + 1; j < graph.vertexNum; j++) {
                if (graph.weight[i][j] != INF) {
                    edges++;
                }
            }
        }
        return edges;
    }
    //得到边集合
    public static List<EData> getEdgeList(Graph graph) {
        List<EData> edges = new ArrayList<>();
        for (int i = 0; i < graph.vertexNum; i++) {
            for (int j = i + 1; j < graph.vertexNum; j++) {
                if (graph.weight[i][j] != INF) {
                    edges.add(new EData(graph.vertexes[i], graph.vertexes[j], graph.weight[i][j]));
                }
            }
        }
        return edges;
    }
}

class Graph {

    public int vertexNum;
    public char[] vertexes;
    public int[][] weight;

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        vertexes = new char[vertexNum];
        weight = new int[vertexNum][vertexNum];
    }

    public void creatGraph(char[] vertexes, int[][] weight, int vertexNum) {
        char[] clone = vertexes.clone();
        for (int i = 0; i < vertexNum; i++) {
            this.vertexes[i] = vertexes[i];
            for (int j = 0; j < vertexNum; j++) {
                this.weight[i][j] = weight[i][j];
            }
        }
    }

    public int getVertexIndex(char vertex) {
        for (int i = 0; i < vertexNum; i++) {
            if (vertexes[i] == vertex) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                System.out.print(weight[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class EData implements Comparable<EData> {

    public char tail;
    public char rear;
    public int weight;

    public EData(char tail, char rear, int weight) {
        this.tail = tail;
        this.rear = rear;
        this.weight = weight;
    }

    @Override
    public int compareTo(EData o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "边<" + tail +", " + rear +">, 权值为" + weight;
    }
}
