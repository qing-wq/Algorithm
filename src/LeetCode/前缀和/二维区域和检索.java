package LeetCode.前缀和;

public class 二维区域和检索 {
    class NumMatrix {
        int[][] matrix;
        int[][] preSum;
        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            int n = matrix.length;
            int m = matrix[0].length;
            preSum = new int[n+1][m+1];
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2][col1 + 1]
                    - preSum[row1 + 1][col2] + preSum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
