package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Solutionzzz {
    public int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int res = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                res += key;
            }
        }
        return res;
    }
}
