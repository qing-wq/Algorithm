package 蓝桥.比赛草稿;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, false);
        }
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int[] left = new int[num];
            for (int j = 0; j < num; j++) {
                left[i] = sc.nextInt();
            }
            int[] right = new int[num];
            for (int j = 0; j < num; j++) {
                right[i] = sc.nextInt();
            }
            String res = sc.next();
            if (res.equals("<")) {

                for (int r : right) {
                    map.put(r, true);
                }
            } else if (res.equals(">")) {
                for (int l : left) {
                    map.put(l, true);
                }
            } else if (res.equals("=")) {
                for (int l : left) {
                    map.put(l, true);
                }
                for (int r : right) {
                    map.put(r, true);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!map.get(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
