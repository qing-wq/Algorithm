package Acwing.前缀和;

import java.util.Scanner;

import java.util.Scanner;

public class 前缀和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] S = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 求前缀和
        // S[i]表示从arr[0]到arr[i-1]
        S[0] = 0;   // 规定
        for (int i = 1; i <= n; i++) {
            S[i] = S[i-1] + arr[i-1];
        }
        while (m > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int res = S[r] - S[l-1];
            System.out.println(res);
            m--;
        }

    }
}
