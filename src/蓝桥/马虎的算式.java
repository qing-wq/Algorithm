package 蓝桥;

public class 马虎的算式 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        for (int e = 1; e < 10; e++) {
                            if ((a * 10 + b) * (c * 100 + d * 10 + e) == (a * 100 + d * 10 + b) * (c * 10 + e)
                                    && a != b && a != c && a != d && a != e && b != c
                                    && b != d && b != e && c != d && c != e && d != e) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
