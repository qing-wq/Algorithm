package 蓝桥;

import java.math.BigDecimal;
import java.math.BigInteger;

public class 黄金连分数 {
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 3; i < 500; i++) {
            BigInteger t = b;
            b = a.add(b);
            a = t;
        }
        BigDecimal d = new BigDecimal(a,110).divide(new BigDecimal(b,110), BigDecimal.ROUND_HALF_DOWN);
        // 输出101位小数，然后自己四舍五入
        System.out.println(d.toPlainString().substring(0,103));
    }
}
