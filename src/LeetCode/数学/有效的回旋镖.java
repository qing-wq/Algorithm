package LeetCode.数学;

public class 有效的回旋镖 {
    class Solution {
        public boolean isBoomerang(int[][] points) {
            // 向量叉乘
            int k1 = (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]);
            int k2 = (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
            return k1!=k2;
        }
    }
}
