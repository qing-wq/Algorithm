package LeetCode.二分;

import com.sun.org.apache.regexp.internal.REUtil;

public class 二分查找 {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l >= r) {
                int mid = l + r >> 1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }
    }


    class Solution2 {
        int target;

        public int search(int[] nums, int target) {
            this.target = target;
            int res = search(nums, 0, nums.length - 1);
        }

        private int search(int[] nums, int left, int right) {
            int mid = left + right >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (left >= right) {
                return -1;
            }

            if (nums[mid] > target) {
                // 这里必须设置为mid，否则报数组下标越界
                return search(nums, left, mid);
            } else {
                return search(nums, mid + 1, right);
            }
        }
    }
}
