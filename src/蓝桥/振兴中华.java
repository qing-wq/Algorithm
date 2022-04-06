package 蓝桥;

public class 振兴中华 {
    public static void main(String[] args) {
        dfs(0, 0);
        System.out.println(cnt);
    }

    static int cnt = 0;

    private static void dfs(int x, int y) {
        if (x >= 3 || y >= 4) {
            cnt++;
            return;
        }
        dfs(x + 1, y);
        dfs(x, y + 1);
    }
}
