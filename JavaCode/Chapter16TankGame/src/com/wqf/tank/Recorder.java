package com.wqf.tank;

import java.io.*;
import java.util.Vector;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Recorder {
    //记录相关信息和文件交互
    private static int shotEnemyTank = 0;
    //定义IO对象
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    public static final String filePath = "src\\myRecord.txt";
    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;
    //定义敌人坦克集合
    static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node对象
    public static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getShotEnemyTank() {
        return shotEnemyTank;
    }

    public static void setShotEnemyTank(int shotEnemyTank) {
        Recorder.shotEnemyTank = shotEnemyTank;
    }

    public static void addShotNum() {
        Recorder.shotEnemyTank++;
    }

    public static void initBuffer() {
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    //读取相关信息
//    public static void readInfo() throws IOException {
//        fileReader = new FileReader(filePath);
//        bufferedReader = new BufferedReader(fileReader);
////        //一行一行的读取
////        //第一行是击毁敌方坦克数目
////        String str = bufferedReader.readLine();
////        shotEnemyTank = Integer.parseInt(str);
////        while ((str = bufferedReader.readLine()) != null) {
////            String[] strings = str.split(str, ' ');
////            int x = Integer.parseInt(strings[0]);
////            int y = Integer.parseInt(strings[1]);
////            int direction = Integer.parseInt(strings[2]);
////            EnemyTank enemyTank = new EnemyTank(x, y, direction);
////            enemyTanks.add(enemyTank);
////        }
//    }
    public static Vector<Node> getNodes() {
        //判断文件是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String str = "";
            if ((str = bufferedReader.readLine()) != null) {
                //最开始的一局
                shotEnemyTank = Integer.parseInt(str);
            }
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);
                int direction = Integer.parseInt(strings[2]);
                Node node = new Node(x, y, direction);
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }
    //记录信息
    public static void recordNum() throws IOException {
        fileWriter = new FileWriter(filePath);
        bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(shotEnemyTank + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive()) {
                    String str = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                    bufferedWriter.write(str + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
