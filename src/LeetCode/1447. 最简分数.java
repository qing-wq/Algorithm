package LeetCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(isRltvPrime(i,j)){
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    
    public static boolean isRltvPrime(int i,int j) {
        if(gcd(i,j)==1){
            return true;
        }else{
            return false;
        }
    }

    private static int gcd(int a, int b) {
        return b == 0?a:gcd(b,a%b);
    }
}
