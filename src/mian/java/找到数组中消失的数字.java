package mian.java;

import java.util.ArrayList;
import java.util.List;

class 找到数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }
         List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}