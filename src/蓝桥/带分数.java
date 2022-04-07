package 蓝桥;

import java.util.Scanner;

public class 带分数 {
    static int n;
    static int[] path = new int[9];
    static int[] st = new int[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(0);
        System.out.println(cnt);
    }

    // 全排列
    private static void dfs(int u) {
        if (u == 9) {
            check(path);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (st[i] == 0) {
                path[u] = i + 1;
                st[i] = 1;
                dfs(u + 1);
                st[i] = 0;
            }
        }
    }

    static int cnt = 0;

    private static void check(int[] path) {
        for (int i = 1; i < 7; i++) {
            int num1 = toInt(0, i);
            if (num1 > n) continue;
            for (int j = i + 1; j < 8; j++) {
                int num2 = toInt(i, j);
                int num3 = toInt(j, 9);
                if (num2 % num3 == 0 && num1 + (num2 / num3) == n ) {
                    cnt++;
                }
            }
        }
    }

    // 转化为整数
    private static int toInt(int start, int end) {
        int num = 0;
        for (int i = start; i <= end - 1; i++) {
            num = num * 10 + path[i];
        }
        return num;
    }
}
