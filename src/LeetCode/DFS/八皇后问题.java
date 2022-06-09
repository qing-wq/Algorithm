package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 八皇后问题 {
    class Solution {
        List<List<String>> res = new ArrayList<>();
        int num;
        int[] status;
        public List<List<String>> solveNQueens(int n) {
            num = n;
            status = new int[n];
            Arrays.fill(status,0);
            char[][] path = new char[n][n];
            for (char[] chars : path) {
                for (char c : chars) {
                    c = '.';
                }
            }
            dfs(0,path);
            return res;
        }

        private void dfs(int row, char[][] path) {
            if (status[num] == 1) {
                add(path);
                return;
            }
            for (int col = 0; col < num; col++) {
                // 判断是否符合
                if (!isValue(path,row,col) && status[row] == 1) {
                    continue;
                }
                // 做选择
                path[row][col] = 'Q';
                status[row] = 1;
                // 递归
                dfs(row+1,path);
                // 回溯
                path[row][col] = '.';
                status[row] = 0;
            }
        }

        private void add(char[][] path) {
            StringBuilder std = new StringBuilder();
            List<String> temp = new ArrayList<>();
            for (char[] chars : path) {
                for (char aChar : chars) {
                    System.out.println(aChar);
                    std.append(aChar);
                }
                System.out.println(std);
                temp.add(std.toString());
                std = new StringBuilder();
            }
            res.add(temp);
        }

        private boolean isValue(char[][] path, int row, int col) {
            // 检查列是否有冲突
            for (int i = 0; i < num; i++) {
                if (path[i][col] == 'Q') {
                    return false;
                }
            }
            // 检查左上角是否冲突
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (path[row][col] == 'Q') {
                    return false;
                }
            }
            // 检查右上角是否冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < num; i--, j++) {
                if (path[row][col] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
    /*...做不出来，cv了*/

    class Solution2 {

        // 表示所有皇后的位置的集合
        List<List<Integer>> res = new ArrayList<>();

        // 表示每次递归之后皇后所处的列，list集合元素的index标识皇后的行
        List<Integer> list = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            backTracking(n, new boolean[n]);
            List<List<String>> result = new ArrayList<>();
            for(List<Integer> thisList : res){
                List<String> temp = new ArrayList<>();
                for(int col : thisList){
                    temp.add(getRes(col, n));
                }
                result.add(temp);
            }
            return result;
        }

        /**
         *
         * @param used 表示当前列是否存在皇后，等同于全排列当前元素是否被使用
         */
        public void backTracking(int n, boolean[] used){
            if(list.size() == n){
                res.add(new ArrayList(list));
                return;
            }
            for(int i = 0; i<n; i++){
                if(used[i] || !isValid(list, i)){
                    continue;
                }
                used[i] = true;
                list.add(i);
                backTracking(n, used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }

        /**
         * 判断当前皇后的位置是否合理
         * @param col 皇后所处的列
         */
        public boolean isValid(List<Integer> list, int col){
            // 因为我们是一行行来防止皇后的，所以这里list的size就是下一个皇后的行
            int row = list.size();
            for(int i = 0; i<list.size(); i++){
                if(Math.abs(col-list.get(i)) == Math.abs(row-i)){
                    return false;
                }
            }
            return true;
        }

        // 根据皇后所处的列，获取字符串
        public String getRes(int col, int n){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<n; i++){
                if(i == col){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            return sb.toString();
        }
    }
}
