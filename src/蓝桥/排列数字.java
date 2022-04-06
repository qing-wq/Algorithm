package 蓝桥;

import java.util.Scanner;

public class 排列数字 {
    static int n;
    static int[] path;
    static int[] st;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int status = 0;
        path = new int[n+1];
        st = new int[n+1];
        // u表示当前枚举到第几个数
        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (st[i] == 0) {
                path[u] = i;
                st[i] = 1;

            dfs(u+1);
            st[i] =0;
            }
        }
    }
}
