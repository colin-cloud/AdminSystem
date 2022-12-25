package com.wqf.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Dijkstra {

    public static final int N = 65535;

    public static void main(String[] args) {

        Graph graph = new Graph(7);
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        graph.creatGraph(vertexes, weight, vertexes.length);
//        graph.display();
        graph.dijkstra(6);
        graph.displayRes();
    }

}

class VisitedVertex {

    public int[] alreadyArr;
    public int[] preVisited;
    public int[] dis;

    public VisitedVertex(int length, int vertexIndex) {
        alreadyArr = new int[length];
        preVisited = new int[length];
        dis = new int[length];
        Arrays.fill(dis, 65535);
        alreadyArr[vertexIndex] = 1;
        dis[vertexIndex] = 0;
    }
    //判断index顶点是否被访问过
    public boolean isVisited(int vertexIndex) {
        return alreadyArr[vertexIndex] == 1;
    }
    //更新index顶点到出发顶点的距离
    public void updateDis(int index, int len) {
        dis[index] = len;
    }
    //更新前驱结点
    public void updatePre(int index, int pre) {
        preVisited[index] = pre;
    }
    //得到出发顶点到index顶点的距离
    public int getDis(int index) {
        return dis[index];
    }
    //得到访问过index后的下一个顶点
    public int getNextIndex(int index) {
        int min = 65535, nextIndex = 0;
        for (int i = 0; i < alreadyArr.length; i++) {
            if (!isVisited(i) && dis[i] < min) {
                min = dis[i];
                nextIndex = i;
            }
        }
        alreadyArr[nextIndex] = 1;
        return nextIndex;
    }
}

class Graph {

    public int vertexNum;
    public char[] vertexes;
    public int[][] weight;
    public VisitedVertex vV;

    public void dijkstra(int index) {
        vV = new VisitedVertex(vertexNum, index);
        update(index);
        for (int i = 1; i < vertexNum; i++) {
            //得到下一个顶点的索引
            int nextIndex = vV.getNextIndex(index);
            update(nextIndex);
        }
    }

    //显示结果
    public void displayRes() {
        for (int i = 0; i < vV.alreadyArr.length; i++) {
            System.out.print(vV.alreadyArr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < vV.preVisited.length; i++) {
            System.out.print(vV.preVisited[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < vV.dis.length; i++) {
            System.out.print(vertexes[i] + "(" + vV.dis[i] + ") ");
        }
    }

    private void update(int index) {
        int len = 0;
        for (int i = 0; i < vertexNum; i++) {
            //出发顶点到index的距离 + index到i的距离
            len = vV.getDis(index) + weight[index][i];
            if (!vV.isVisited(i) && len < vV.getDis(i)) {
                //更新前驱结点
                vV.updatePre(i, index);
                //更新出发顶点到i的距离
                vV.updateDis(i, len);
            }
        }
    }

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

