class Solution {
    static int  m,n;
    static int[][] mat;
    public List<Integer> luckyNumbers (int[][] matrix) {
        mat = matrix;
        List<Integer> list = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        int f=0,g=0;
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                    f = i;
                    g = j;
                }
            }
            if(maxValue(f,g)) list.add(min);
        }
        return list;
    }
    public static boolean maxValue(int a,int b) {
        int max = mat[a][b];
        for (int i = 0; i < m; i++) {
            if(max<mat[i][b]) {
                return false;
            } 
        }
        return true;
    }
}
