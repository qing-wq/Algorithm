package LeetCode.前缀和;

public class 区域和检索_数组可修改 {
    class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        // 更新数组中的元素
        public void update(int index, int val) {
            nums[index] = val;
        }

        // 区域和检索
        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
