package LeetCode.前缀和;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0, 1);
            int cnt = 0;
            int sumi = 0;
            for (int i = 0; i < nums.length; i++) {
                sumi += nums[i];
                System.out.println(sumi+" "+i);
                int sumj = k - sumi;
                if (map.containsKey(sumj)) {
                    cnt += map.get(sumj);
                }
                map.put(sumi, map.getOrDefault(sumi, 0) + 1);
            }
            return cnt;   // 不行了，好难理解55555
        }
    }
}
