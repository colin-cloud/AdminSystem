package com.wqf.algorithm.floyd;


/**
 * @author 小白学java
 * @version 3.0
 */
public class Floyd {

    public static final int N = 65535;

    public static void main(String[] args) {

        Graph graph = new Graph(7);
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}
        };
        graph.creatGraph(vertexes, weight, vertexes.length);
        graph.floyd();
        graph.display();
    }
}

class Graph {

    public int vertexNum;
    public char[] vertexes;
    public int[][] weight;
    public int[][] pre;

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        vertexes = new char[vertexNum];
        weight = new int[vertexNum][vertexNum];
        pre = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                pre[i][j] = i;
            }
        }
    }

    public void floyd() {
        int len = 0;
        //以i为中间顶点
        for (int i = 0; i < vertexNum; i++) {
            //从j出发
            for (int j = 0; j < vertexNum; j++) {
                //到达k
                for (int k = 0; k < vertexNum; k++) {
                    len = weight[j][i] + weight[i][k];
                    if (len < weight[j][k]) {
                        weight[j][k] = len;
                        pre[j][k] = pre[i][k];
                    }
                }
            }
        }
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
                System.out.print(pre[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                String str = weight[i][j] == 65535 ? "N" : ("" + weight[i][j]);
                System.out.print("" + vertexes[i] + "->" + vertexes[j] + ":" + str + "\t");
            }
            System.out.println();
        }
    }
}
