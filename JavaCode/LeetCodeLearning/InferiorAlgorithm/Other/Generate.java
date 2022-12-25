import java.util.*;

public class Generate { 
    public static void main(String[] args) { 
       
    }
    
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return null;
        }
        //得到杨辉三角的集合
        List<List<Integer>> triangleEles = new ArrayList(numRows);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        triangleEles.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> rowEles = new ArrayList(i + 1);
            if (i == 1) {
                rowEles.add(1);
                rowEles.add(1);
            } else {
                //从第三行开始添加额外元素
                rowEles.add(1);
                //先得到上一行的list
                List<Integer> preRow = triangleEles.get(i - 1);
                for (int j = 0; j < preRow.size() - 1; j++) {
                    int sum = preRow.get(j) + preRow.get(j + 1);
                    rowEles.add(sum);
                }
                rowEles.add(1);
            }
            triangleEles.add(rowEles);
        }
        return triangleEles;
    }
}