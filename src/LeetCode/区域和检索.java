package LeetCode;

public class 区域和检索 {
    class NumArray {
        int[] nums;
        int[] S;
        public NumArray(int[] nums) {
            this.nums = nums;
            S = new int[nums.length];
            S[0] = 0;
//            for (int i = 1; i < nums.length; i++) {
//                for (int j = 0; j <= i; j++) {
//                    S[i] += nums[i];
//                }
//            }
            for (int i = 1; i < nums.length; i++) {
                S[i] = S[i-1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return S[right] - S[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
