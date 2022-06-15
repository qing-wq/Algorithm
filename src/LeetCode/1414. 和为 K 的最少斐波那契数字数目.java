package LeetCode;

import java.util.ArrayList;
import java.util.List;

class Solutionaaa {
    static List<Integer> list = new ArrayList<>();
    public int findMinFibonacciNumbers(int k) {
        list.add(1);
        fbnq(1, 1, k);
        int res = 0;
        int maxInt = list.size()-1;
        while(k!=0){
            if(k>=list.get(maxInt)){
                k = k - list.get(maxInt);
                res++;
            }
            maxInt--;
        }
        return res;
    }
    public static void fbnq(int a,int b,int k){
        if(b>=k) return ;
        int c = a + b;
        list.add(c);
        fbnq(b, c, k);
    }
}
