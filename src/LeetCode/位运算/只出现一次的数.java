package LeetCode.位运算;

public class 只出现一次的数 {
    class Solution {
        public int singleNumber(int[] nums) {
            int statue = 0;
            for (int num : nums) {
                statue ^= num;
            }
            return statue;
        }
    }
}
