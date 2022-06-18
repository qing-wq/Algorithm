package 蓝桥.比赛草稿;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextInt();
        long r = scanner.nextInt();
        long sum = 0;
        for (long i = l; i <= r; i++) {
            String num = String.valueOf(i);
            if (num.contains("2022")) {
                sum +=i;
            }
        }
        System.out.println(sum);
    }
}
