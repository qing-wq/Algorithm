package mian.java;

class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int p = 0;
        int i = 0,j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[p++] = nums1[i];
                i++;
            } else {
                temp[p++] = nums2[j];
                j++;
            }
        }
        System.out.println(i + " " + j);
        if ((i < m) && j == n) {
            while (i < m) {
                temp[i + j] = nums1[i];
                i++;
            }
        }
        if (j < n && i == m) {
            while (j < n) {
                temp[j + i] = nums2[j];
                j++;
            }
        }
        for (int k = 0; k < temp.length; k++) {
            nums1[k] = temp[k];
        }
    }
}