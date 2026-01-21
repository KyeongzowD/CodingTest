import java.util.PriorityQueue;

class Solution {
    static class Way{
        int from, to, cost;
        Way(int from, int to, int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }

    static int[] root;
    public static int solution(int n, int[][] costs) {
        PriorityQueue<Way> ways = new PriorityQueue<Way>(
                (o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int len = costs.length;
        for (int i = 0; i < len; i++) {
            ways.offer(new Way(costs[i][0], costs[i][1], costs[i][2]));
        }

        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        int answer = 0, edgesUsed = 0; // 출력값, 지나간 섬의 수

        while (!ways.isEmpty() && edgesUsed < n - 1) {
            Way w = ways.poll();

            if (findRoot(w.from) == findRoot(w.to)) continue;

            union(w.from, w.to);
            answer += w.cost;
            edgesUsed++;
        }

        return answer;
    }

    static int findRoot(int x) {
        if (root[x] == x) return x;
        root[x] = findRoot(root[x]);
        return root[x];
    }

    static void union(int a, int b) {
        int pa = findRoot(a);
        int pb = findRoot(b);
        if (pa == pb) return;

        root[pb] = pa;
    }
}