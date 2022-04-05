package LeetCode.字符串;

import java.time.Year;
import java.util.Arrays;

public class 字符串相加 {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            // 双指针
            int i = num1.length() - 1, j = num2.length() - 1;
            int t = 0;  // 保存进位
            int max = Math.max(num1.length(), num2.length());
            while (--max > 0) {
                int a = i < 0 ? 0 : num1.charAt(i--) - '0';
                int b = j < 0 ? 0 : num2.charAt(j--) - '0';
                int m = (a + b + t);
                res.append(m % 10);
                t = m / 10;
            }
            if (t != 0) res.append("1");
            return res.reverse().toString();
        }
    }
}
