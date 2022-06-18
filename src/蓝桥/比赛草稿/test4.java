package 蓝桥.比赛草稿;

import com.sun.org.apache.regexp.internal.RE;
import sun.applet.Main;

import java.util.*;

public class test4 {
    static char[][] MyDesktop;
    static LinkedList<Integer> list = new LinkedList<>();
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MyDesktop = new char[2*n][2*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                MyDesktop[i][j] = '.';
            }
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            String op = sc.next();
            if (op.equals("new")) {
                int pid = sc.nextInt();
                int top = sc.nextInt();
                int left = sc.nextInt();
                int height = sc.nextInt();
                int width = sc.nextInt();
                myNew(pid, top, left, height, width);
            } else if (op.equals("move")) {
                int pid = sc.nextInt();
                int v = sc.nextInt();
                int h = sc.nextInt();
                move(pid, v, h);
            } else if (op.equals("resize")) {
                int pid = sc.nextInt();
                int h = sc.nextInt();
                int w = sc.nextInt();
                resize(pid, h, w);
            } else if (op.equals("close")) {
                int pid = sc.nextInt();
                close(pid);
            } else if (op.equals("active")) {
                int pid = sc.nextInt();
                active(pid);
            }
        }
        System.out.println(Arrays.toString(map.get(1)));
        for (int i = list.size() - 1; i >= 0; i--) {
            int pid = list.get(i);
            int[] arr = map.get(pid);
            int top = arr[0];
            int left = arr[1];
            int h = arr[2];
            int width = arr[3];
            int right = left + width - 1;
            int btn = top + h - 1;
            // 画四个角
            MyDesktop[top][left] = '+';
            MyDesktop[top][right] = '+';
            MyDesktop[btn][left] = '+';
            MyDesktop[btn][right] = '+';
            //画四条边
            for (int j = left + 1; j < right; j++) {
                MyDesktop[top][j] = '-';
                MyDesktop[btn][j] = '-';
            }
            for (int j = top + 1; j < btn; j++) {
                MyDesktop[j][left] = '|';
                MyDesktop[j][right] = '|';
            }
            // 其他
            for (int j = top + 1; j < btn; j++) {
                for (int l = left+1; l < right; l++) {
                    MyDesktop[j][l] = ' ';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(MyDesktop[i][j]);
            }
            System.out.println();
        }
    }

    public static void myNew(int pid, int top, int left, int height, int width) {
        list.addFirst(pid);
        map.put(pid, new int[]{top, left, height, width});
    }

    public static void move(int pid, int vertical, int horizontal) {
        int index = list.indexOf(pid);
        list.remove(index);
        list.addFirst(pid);
        int[] arr = map.get(pid);
        arr[0] += vertical;
        arr[1] += horizontal;
        int[] narr = new int[arr.length];
        System.arraycopy(arr, 0, narr, 0, arr.length);
        map.put(pid, narr);
    }

    public static void resize(int pid, int height, int width) {
        int index = list.indexOf(pid);
        list.remove(index);
        list.addFirst(pid);
        int[] arr = map.get(pid);
        arr[2] = height;
        arr[3] = width;
        int[] narr = new int[arr.length];
        System.arraycopy(arr, 0, narr, 0, arr.length);
        map.put(pid, narr);
    }

    public static void close(int pid) {
        int index = list.indexOf(pid);
        list.remove(index);
    }

    public static void active(int pid) {
        int index = list.indexOf(pid);
        list.remove(index);
        list.addFirst(pid);
    }
}
