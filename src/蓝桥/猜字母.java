package 蓝桥;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 猜字母 {
    public static void main(String[] args) {
        char[] arr = new char[2014];
        char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's'};
        int len = 0;
        while (len < 2014) {
            int i = len % 19;
            arr[len] = ch[i];
            len++;
        }

        while (len > 1) {
            int k = 0;
            for (int i = 1; i < len; i += 2) {
                arr[k++] = arr[i];
            }
            len = k;
        }
        System.out.println(arr[0]);
    }
}
