package 蓝桥;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    static class State{
        // 图节点id
        int id;
        int distFromStart;   // 从起点到当前节点的距离

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public static int[] Dijkstra(int start , List<Integer>[] graph) {
        int V = graph.length;  // 图中节点的个数
        int distTo[] = new int[V];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        // 优先队列，distFromStart小的排在前面
        Queue<State> pq = new PriorityQueue<>((a,b) ->{
            return a.distFromStart - b.distFromStart;
        });

        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curID = cur.id;
            int curDistFromStart = cur.distFromStart;
            // 如果已经由更短路到当前节点了
            if (curDistFromStart > distTo[curID]) {
                continue;
            }
            for (int nextID : adj(curID)) {
                int distToNext = distTo[curID] + weight(curID, nextID);
                if (distToNext < distTo[nextID]) {
                    distTo[nextID] = distToNext;
                    pq.offer(new State(nextID, distToNext));
                }
            }
        }
        return distTo;
    }

    private static int weight(int curID, int nextID) {
        return 0;  // 返回权重
    }

    private static int[] adj(int curID) {
        return new int[0];  // 返回相邻节点
    }
}
