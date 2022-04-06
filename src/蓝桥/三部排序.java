package 蓝桥;

public class 三部排序 {
    static void sort(int[] x)
    {
        int p = 0;
        int left = 0;
        int right = x.length-1;

        while(p<=right){
            if(x[p]<0){
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            }
            else if(x[p]>0){
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;
            }
            else{
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {25, 18, -2, 0, 16, -5, 33, 21, 0, 19, -16, 25, -3, 0};
        三部排序.sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
