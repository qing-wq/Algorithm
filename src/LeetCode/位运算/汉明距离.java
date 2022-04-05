package LeetCode.位运算;

public class 汉明距离 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int xor = x^y;
            int distance = 0;
            while (xor != 0) {
                distance++;
                xor = xor & (xor - 1);
            }
            return distance;
        }
    }
}
