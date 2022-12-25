package com.wqf.algorithm.prim;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Prim {

    public static void main(String[] args) {

        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexNum = vertexes.length;
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000,  2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        Graph graph = new Graph(vertexNum);
        graph.creatGraph(vertexes, weight, vertexNum);
        prim(graph, 0);
    }

    //普利姆算法本质上是最小生成树问题 - 树的权值最小
    public static void prim(Graph graph, int vertex) {
        //得到顶点数量
        int vertexNum = graph.vertexNum;
        //定义数组来判断顶点是否被访问过
        int[] isVisited = new int[vertexNum];
        //设置当前顶点为访问过
        isVisited[vertex] = 1;
        //用来保存最小路径
        int minWeight = 10000;
        //用来保存最小路径的两个顶点的索引值
        int index1 = -1;
        int index2 = -1;
        //普利姆算法得到的边数目为vertexNum - 1
        for (int k = 1; k < vertexNum; k++) {
            for (int i = 0; i < vertexNum; i++) {
                for (int j = 0; j < vertexNum; j++) {
                    if (isVisited[i] == 1 && isVisited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        index1 = i;
                        index2 = j;
                    }
                }
            }
            System.out.printf("边<%c, %c>, 权值为%d \n",
                    graph.vertexes[index1], graph.vertexes[index2], graph.weight[index1][index2]);
            //设置访问过
            isVisited[index2] = 1;
            minWeight = 10000;
        }
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
        for (int i = 0; i < vertexNum; i++) {
            this.vertexes[i] = vertexes[i];
            for (int j = 0; j < vertexNum; j++) {
                this.weight[i][j] = weight[i][j];
            }
        }
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
