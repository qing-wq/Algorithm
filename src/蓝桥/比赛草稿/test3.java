package 蓝桥.比赛草稿;

import java.util.*;

public class test3 {
    public static void main(String[] args) {
        LinkedList<Integer> res = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            res.addLast(i);
        }
        for (int i = 0; i < m; i++) {
            String p = sc.next();
            System.out.println(p);
            int num = sc.nextInt();
            int index = res.indexOf(num);
            res.remove(index);
            if (p.equals("L")) {
                res.addFirst(num);
            }
            if (p.equals("R")) {
                res.addLast(num);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
