package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

// BFS模板题
public class 走迷宫 {
    static int n;
    static int m;
    private static final int N = 110;
    static int[][] g = new int[N][N];   // 存图
    static int[][] d = new int[N][N];   // 标记
    static Queue<Point> q = new ArrayDeque<>();
    static class Point{
        int x, y,step;    // 坐标，步长

        public Point(){};

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
//    static int[][] q = new int[110*110][];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

//        g = new int[n][m];
//        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs();
    }

    private static void  bfs() {
        q.add(new Point(0, 0, 0));

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        while (!q.isEmpty()) {
            Point t = q.poll();
            if (t.x == n-1 && t.y == m-1) {
                System.out.println(t.step);
                return ;
            }
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                if (x < n && y < m && x >= 0 && y >= 0 && g[x][y] == 0 && d[x][y] == 0) {
                    d[x][y] = 1;
                    q.add(new Point(x, y, t.step + 1));
                }
            }
        }
    }
}
