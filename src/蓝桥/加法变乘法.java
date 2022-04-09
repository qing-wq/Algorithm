package 蓝桥;

public class 加法变乘法 {
    public static void main(String[] args) {
        for (int i = 11; i <50; i++) {

        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
