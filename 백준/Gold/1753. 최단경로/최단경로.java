import java.io.*;
import java.util.*;

public class Main {
    static class Node { // 도착점과 가중치
        int to, len;

        Node(int to, int len) {
            this.to = to;
            this.len = len;
        }
    }

    static class Edge { //출발점과 가중치
        int from, len;

        Edge(int from, int len) {
            this.from = from;
            this.len = len;
        }
    }

    static int V, E, K;
    static long[] dist; //각 정점의 최단 경로
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        list = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++) list[i] = new ArrayList<Node>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[idx].add(new Node(to, len));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Long.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void dijkstra(int idx) {
        PriorityQueue<Edge> que = new PriorityQueue<>(Comparator.comparingInt(n -> n.len));
        dist[K] = 0;
        que.offer(new Edge(K, 0));

        while (!que.isEmpty()) {
            Edge edge = que.poll();
            int v = edge.from;
            int d = edge.len;

            if (d > dist[v]) continue;

            for (Node node : list[v]) {
                int len = d + node.len;
                if (len < dist[node.to]) {
                    dist[node.to] = len;
                    que.offer(new Edge(node.to, len));
                }
            }
        }
    }
}
