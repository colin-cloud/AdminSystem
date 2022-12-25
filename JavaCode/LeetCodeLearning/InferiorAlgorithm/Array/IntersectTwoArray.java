import java.util.*;

public class Algorithm { 
    public static void main(String[] args) { 
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    
    public static int[] intersect(int[] nums1, int[] nums2){
        //hashMap的key表示数，value表示数出现的次数
        Map<Integer, Integer> hashMap = new HashMap();
        List<Integer> li = new ArrayList();
        //先遍历nums1将其中的数存放进去
        for (int i = 0; i < nums1.length; i++){
            if (!hashMap.containsKey(nums1[i])){
                hashMap.put(nums1[i], 1);
            } else {
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            }
        }
        //遍历nums2,将交集放到list中
        for (int j = 0; j < nums2.length; j++){
            if (hashMap.containsKey(nums2[j])&&hashMap.get(nums2[j])>0){
                hashMap.put(nums2[j], hashMap.get(nums2[j]) - 1);
                li.add(nums2[j]);
            }
        }
        //将list中的内容拷贝到数组当中
        int[] results = new int[li.size()];
        for (int k = 0; k < results.length; k++){
            results[k] = li.get(k);
        }
        
        return results;
   }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}