package 蓝桥;

public class 武功秘籍 {
    public static void main(String[] args) {
        int cnt =0;
        for (int i = 10; i < 100; i += 2) {
            if (i >= 81 && i <= 92) {
                cnt++;
                System.out.println(i);
            }
        }
        System.out.println();
    }
}
