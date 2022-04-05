package LeetCode.位运算;

public class 比特位计数 {
    // 动态规划解
    class Solution {
        public int[] countBits(int n) {
            int[] bit = new int[n + 1];
            int height = 0;   // 最高有效位
            for (int i = 0; i <= n; i++) {
                // 判断是否为2的整数次幂
                if ((i & (i - 1)) == 0) {
                    height = i;
                }
                bit[i] = bit[i - height] + 1;
            }
            return bit;
        }
    }
}
