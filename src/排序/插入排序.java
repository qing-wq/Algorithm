package 排序;

public class 插入排序 {
    public int[] SortArray(int[] arr) {
        // 当前待排序的元素值
        int currentValue;
        for (int i = 0; i < arr.length; i++) {
            // 已经排序好的索引
            int preIndex = i;
            currentValue = arr[preIndex + 1];
            // 如果当前元素小于前一个，将前一个后移一位
            while (currentValue < arr[preIndex] && preIndex >= 0) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            // 插入
            arr[preIndex] = currentValue;
        }
        return arr;
    }
}
