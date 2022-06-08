package LeetCode.DFS;

class Solution {
    public static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static int m;
    public static int n;
    static boolean[][] visited;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for (int j = 1; j < n; j++) {
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1&&!visited[i][j]){
                    res ++;
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] grid,int c,int r){
        if(c<0||c>=m||r<0||r>=n||grid[c][r]==0||visited[c][r]){
            return;
        }
        visited[c][r] = true;
        for(int[] dir : dirs){
            dfs(grid, c+dir[0], r+dir[1]);
        }
    }
}
