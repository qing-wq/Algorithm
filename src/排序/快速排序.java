package 排序;

public class 快速排序 {
    // 快速排序原理：在区间中随机找一个数作为基准数，比基准数小的放在前，大的放在后，在对分区指示器两边的数进行快排
    public static int[] SortArray(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int start, int end) {
        if (start < 0 || arr.length <= 0 || end > arr.length - 1 || start > end) {
            return null;
        }
        // 分区指示器
        int zeroIndex = partition(arr, start, end);
        if(zeroIndex>start)
            sort(arr,start,zeroIndex-1);
        if(zeroIndex < end)
            sort(arr, zeroIndex + 1, end);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("==========================");
        return arr;
    }
    // 分区方法
    private static int partition(int[] arr, int start, int end) {
        // 当只有一个元素，不用再分区
        if (start == end) {
            return start;
        }
        // 设置基准数
        int pivot = (int) (start + Math.random() * (end - start) + 1);
        // 将基准数与分区尾数交换位置
        swap(arr, pivot, end);
        // zeroInDex是分区指示器，初始值为start-1
        int zeroIndex = start -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {
                // 如果当前元素小于基准数，zeroIndex+1
                zeroIndex++;
                if (i > zeroIndex) {
                    // 如果当前元素的下标小于分区指示器，将分区指示器所指元素与当前元素交换位置
                    swap(arr, i, zeroIndex);
                }
            }
        }
        return zeroIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3,9,11,65,8,7};
        new 快速排序().SortArray(arr);
    }
}
