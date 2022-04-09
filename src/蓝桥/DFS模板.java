package 蓝桥;

import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class DFS模板 {

    public static void bfs(Node start){
        Queue<Node> q = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();   // 去重

        int step = 0;  // 记录步长
        q.add(start);   // 将第一个节点入队
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                // 将所有相邻的节点加入队列
                for (Node neighbour : cur.adj()) {
                    if (visited.contains(neighbour)){
                        q.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            step++;
        }
    }
    public static void main(String[] args) {
        bfs(start);
    }

    public static int weight(int from, int to) {
        return 0;
    }


}
