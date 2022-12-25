import java.util.*;

public class Merge { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        int len = intervals.length;
        List<int[]> l = new ArrayList();
        for (int i = 0; i < len; i++) {
            l.add(intervals[i]);
        }
        Collections.sort(l, new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[0] - n[0];
            }
        });
        List<int[]> list = new ArrayList();
        for (int i = 0; i < len ; i++) {
            int index = i;
            int maxVal = l.get(index)[1];
            while (index + 1 < len) {
                int rearMin = l.get(index + 1)[0];
                int rearMax = l.get(index + 1)[1];
                if (maxVal >= rearMin) {
                    if (maxVal < rearMax) {
                        maxVal = rearMax;
                    }
                    index++;
                } else {
                    break;
                }
            }
            int[] nums = new int[2];
            nums[0] = l.get(i)[0];
            nums[1] = maxVal;
            list.add(nums);
            i = index;
        }
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] interval : list) {
            res[i] = interval;
            i++;
        }
        return res;
    }
}