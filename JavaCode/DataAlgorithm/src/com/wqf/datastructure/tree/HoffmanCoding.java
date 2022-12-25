package com.wqf.datastructure.tree;



import java.io.*;
import java.util.*;

/**
 * @author 小白学java
 * @version 3.0
 */
public class HoffmanCoding {

    public static void main(String[] args) {
//        String str = "i like java";
//        byte[] huffmanZip = huffmanZip(str);
//        System.out.println(Arrays.toString(huffmanZip));
        //测试压缩赫夫曼编码数组
//        List<Knot> list = getKnotList(str);
//        Knot root = getHuffmanTreeRoot(list);
//        Map<Byte, String> huffmanCodingTable = getHuffmanCodingTable(root);
//        String coding = getHuffmanCoding(str, huffmanCodingTable);
//        byte[] zip = zip(coding);
//        String originalString = getOriginalString(huffmanCodingTable, zip);
//        System.out.println(originalString);

//        String src = "C:\\Users\\wwww\\Pictures\\Saved Pictures\\女孩.jpg";
//        String dest = "D:\\JAVA入门\\Note take\\女孩.zip";
//        zipFile(src, dest);
//        System.out.println("ok");

        String src = "D:\\JAVA入门\\Note take\\女孩.zip";
        String dest = "D:\\JAVA入门\\Note take\\女孩.jpg";
        fileDecode(src, dest);
        System.out.println("ok");
    }

    //编写方法将文件进行解压
    public static void fileDecode(String srcPath, String destPath) {
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(srcPath);
            ois = new ObjectInputStream(is);
            byte[] bytes = (byte[]) ois.readObject();
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            byte[] bytes1 = getBytes(codes, bytes);
            os = new FileOutputStream(destPath);
            os.write(bytes1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                is.close();
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //编写方法将一个文件进行压缩
    public static void zipFile(String srcPath, String destPath) {
        //创建输入流
        FileInputStream is = null;
        //创建输出流
        FileOutputStream os = null;
        //创建对象流
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcPath);
            //读取文件
            byte[] huffmanBytes = new byte[is.available()];
            is.read(huffmanBytes);
            os = new FileOutputStream(destPath);
            //得到对应的赫夫曼编码表
            Map<Byte, String> table = getHuffmanCodingTable(getHuffmanTreeRoot(getKnotList(huffmanBytes)));
            //进行压缩
            byte[] huffmanZip = huffmanZip(huffmanBytes);
            //输出压缩文件
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanZip);
            oos.writeObject(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //得到对应的字符串
    public static String getOriginalString(Map<Byte, String> map, byte[] bytes) {
        //得到对应的赫夫曼二进制字符串
        boolean flag = true;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                flag = false;
            }
            String str = getStrForByte(flag, bytes[i]);
            builder.append(str);
        }
        //111101100111011000101010110001110
        String huffmanCoding = builder.toString();
        //反置map
        Map<String, Byte> tempMap = new HashMap<>();
        for (Byte b : map.keySet()) {
            tempMap.put(map.get(b), b);
        }
        //设定索引
        int i = 0;
        int j = 1;
        //存放原始字符串对应的byte数组
//        byte[] originalBytes = new byte[20];
        List<Byte> originalBytes = new ArrayList<>();
//        int index = 0;
        while (j < huffmanCoding.length()) {
            //根据反置map来找到对应的字符
            String substring;
            Byte by;
            substring = huffmanCoding.substring(i, j);
            by = tempMap.get(substring);
            while (by == null && j < huffmanCoding.length()) {
                //表示没有与之对应的字符
                j++;
                substring = huffmanCoding.substring(i, j);
                by = tempMap.get(substring);
            }
            originalBytes.add(by);
//            index++;
            i = j;
            j++;
        }
        //得到原始字符串
        StringBuilder builder1 = new StringBuilder();
        for (byte b : originalBytes) {
            char ch = (char) b;
            builder1.append(ch);
        }
        return builder1.toString();
    }
    //得到byte数组
    public static byte[] getBytes(Map<Byte, String> map, byte[] bytes) {
        //得到对应的赫夫曼二进制字符串
        boolean flag = true;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                flag = false;
            }
            String str = getStrForByte(flag, bytes[i]);
            builder.append(str);
        }
        //111101100111011000101010110001110
        String huffmanCoding = builder.toString();
        //反置map
        Map<String, Byte> tempMap = new HashMap<>();
        for (Byte b : map.keySet()) {
            tempMap.put(map.get(b), b);
        }
        //设定索引
        int i = 0;
        int j = 1;
        //存放原始字符串对应的byte数组
//        byte[] originalBytes = new byte[20];
        List<Byte> originalBytes = new ArrayList<>();
//        int index = 0;
        while (j < huffmanCoding.length()) {
            //根据反置map来找到对应的字符
            String substring;
            Byte by;
            substring = huffmanCoding.substring(i, j);
            by = tempMap.get(substring);
            while (by == null && j < huffmanCoding.length()) {
                //表示没有与之对应的字符
                j++;
                substring = huffmanCoding.substring(i, j);
                by = tempMap.get(substring);
            }
            originalBytes.add(by);
//            index++;
            i = j;
            j++;
        }
        byte[] bytes1 = new byte[originalBytes.size()];
        int index = 0;
        for (byte b : originalBytes) {
            bytes1[index] = b;
            index++;
        }
        return bytes1;
    }
    //得到一个byte所对应的二进制字符串
    public static String getStrForByte(boolean flag, byte b) {
        int temp = b;
        //得到对应的二进制形式
        if (flag) {
            temp |= 256;
        }
        String binaryString = Integer.toBinaryString(temp);
        if (flag) {
            return binaryString.substring(binaryString.length() - 8);
        } else {
            return binaryString;
        }
    }
    //封装方法
    public static byte[] huffmanZip(String string) {
        List<Knot> list = getKnotList(string);
        Knot root = getHuffmanTreeRoot(list);
        Map<Byte, String> huffmanCodingTable = getHuffmanCodingTable(root);
        String coding = getHuffmanCoding(string, huffmanCodingTable);
        byte[] zip = zip(coding);
        return zip;
    }
    public static byte[] huffmanZip(byte[] bytes) {
        List<Knot> list = getKnotList(bytes);
        Knot root = getHuffmanTreeRoot(list);
        Map<Byte, String> huffmanCodingTable = getHuffmanCodingTable(root);
        String coding = getHuffmanCoding(bytes, huffmanCodingTable);
        byte[] zip = zip(coding);
        return zip;
    }

    //得到字符对应的出现个数
    public static List<Knot> getKnotList(String string) {
        //先得到字符串对应数组
        byte[] bytes = string.getBytes();
        //创建集合
        ArrayList<Knot> knots = new ArrayList<>();
        //创建map来创建对应的knot
        Map<Byte, Integer> map = new HashMap<>();
        //遍历map得到对应字符出现的个数
        for (Byte bt : bytes) {
            //从map中得到对应的value
            Integer integer = map.get(bt);
            if (integer == null) {
                //说明map中还没有存放对应的字符
                //添加字符
                map.put(bt, 1);
            } else {
                //说明map中已经存放了对应的字符
                map.put(bt, integer + 1);
            }
        }

        //遍历map得到结点
        for (Byte bt : map.keySet()) {
            knots.add(new Knot(map.get(bt), bt));
        }
        return knots;
    }
    public static List<Knot> getKnotList(byte[] bytes) {
        //先得到字符串对应数组
        //创建集合
        ArrayList<Knot> knots = new ArrayList<>();
        //创建map来创建对应的knot
        Map<Byte, Integer> map = new HashMap<>();
        //遍历map得到对应字符出现的个数
        for (Byte bt : bytes) {
            //从map中得到对应的value
            Integer integer = map.get(bt);
            if (integer == null) {
                //说明map中还没有存放对应的字符
                //添加字符
                map.put(bt, 1);
            } else {
                //说明map中已经存放了对应的字符
                map.put(bt, integer + 1);
            }
        }

        //遍历map得到结点
        for (Byte bt : map.keySet()) {
            knots.add(new Knot(map.get(bt), bt));
        }
        return knots;
    }

    //创建赫夫曼树
    public static Knot getHuffmanTreeRoot(List<Knot> knots) {
        while (knots.size() > 1) {
            //进行排序
            Collections.sort(knots);
            Knot left = knots.remove(0);
            Knot right = knots.remove(0);
            //创建新的结点
            Knot knot = new Knot(left.value + right.value);
            knot.left = left;
            knot.right = right;
            //添加到集合中
            knots.add(knot);
        }
        return knots.remove(0);
    }

    //进行前序遍历
    public static void preOrderList(Knot root) {
        if (root != null) {
            root.preOrderList();
        } else {
            System.out.println("根结点为空,无法遍历~");
        }
    }

    //得到赫夫曼编码表
    public static Map<Byte, String> getHuffmanCodingTable(Knot root) {
        Map<Byte, String> map = new HashMap<Byte, String>();
        getCoding(map, root, "", new StringBuilder());
        return map;
    }

    //递归进行操作

    /**
     * @param map           赫夫曼编码表
     * @param knot          当前结点
     * @param path          路径
     * @param stringBuilder 拼接字符串
     */
    public static void getCoding(Map<Byte, String> map, Knot knot, String path, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(path);
        if (knot != null) {
            //判断是不是叶子结点
            if (knot.ch == null) {
                //非叶子结点
                //向左递归
                getCoding(map, knot.left, "0", stringBuilder1);
                //向右递归
                getCoding(map, knot.right, "1", stringBuilder1);
            } else {
                //叶子结点
                map.put(knot.ch, stringBuilder1.toString());
            }
        }
    }

    //得到对应的赫夫曼编码
    public static String getHuffmanCoding(String str, Map<Byte, String> map) {
        byte[] bytes = str.getBytes();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            builder.append(map.get(bytes[i]));
        }
        return builder.toString();
    }
    public static String getHuffmanCoding(byte[] bytes, Map<Byte, String> map) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            builder.append(map.get(bytes[i]));
        }
        return builder.toString();
    }

    //得到赫夫曼编码对应的byte数组
    public static byte[] zip(String coding) {
        //切割字符串
        int length = 0;
        if (coding.length() % 8 == 0) {
            length = coding.length() / 8;
        } else {
            length = coding.length() / 8 + 1;
        }
        byte[] bytes = new byte[length];
        int index = 0;
        for (int i = 0; i < coding.length(); i += 8) {
            String strBy = "";
            if (i + 8 > coding.length()) {
                strBy = coding.substring(i);
            } else {
                strBy = coding.substring(i, i + 8);
            }
            bytes[index] = (byte)Integer.parseInt(strBy, 2);
            index++;
        }
        return bytes;
    }
}

class Knot implements Comparable<Knot> {

    public int value;
    public Byte ch;
    public Knot left;
    public Knot right;

    public void preOrderList() {
        System.out.println(this);
        if (left != null) {
            left.preOrderList();
        }
        if (right != null) {
            right.preOrderList();
        }
    }

    @Override
    public String toString() {
        return "Knot{" +
                "value=" + value +
                ", ch=" + ch +
                '}';
    }

    public Knot(int value, byte ch) {
        this.value = value;
        this.ch = ch;
    }

    public Knot(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Knot o) {
        return this.value - o.value;
    }
}
