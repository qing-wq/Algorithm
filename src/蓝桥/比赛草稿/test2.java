package 蓝桥.比赛草稿;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        int[] prime = new int[648];
        int n = 0;
        for (int i = 3; i <= Math.sqrt(23333333); i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) prime[n++] = i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2333333; i < 23333333; i++) {
            int cnt = 0;
            int end = (int) Math.sqrt(i);
            int temp = i;
            int j = 0;
            while (temp != 1 && prime[j]<end && j<648) {
                if (temp % prime[j] == 0) {
                    temp /= prime[j];
                    j = 0;
                    cnt++;
                    end = (int) Math.sqrt(temp);
                }
                j++;
            }
            System.out.println(cnt);
            if (cnt == 12) list.add(i);
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
