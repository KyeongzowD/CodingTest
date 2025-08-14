import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int end, dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }

    static int N, M, X, ans;
    static List<Node>[] list; // 모든 간선
    static int[] len; // 각자의 집에서 X까지 도달하는데 걸리는 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        len = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, dist));
        }

        for (int i = 1; i < N+1; i++) {
            len[i] = dijkstra(i, X) + dijkstra(X, i);
        }

        ans = len[1];
        for (int i = 2; i < N+1; i++) {
            if (len[i] > ans) ans = len[i];
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;
        que.offer(new Node(start, 0));

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (node.dist > dists[node.end]) continue;

            for (Node next : list[node.end]) {
                if (next.dist + dists[node.end] < dists[next.end]) {
                    dists[next.end] = next.dist + dists[node.end];

                    que.offer(new Node(next.end, dists[next.end]));
                }
            }
        }
        return dists[end];
    }
}
