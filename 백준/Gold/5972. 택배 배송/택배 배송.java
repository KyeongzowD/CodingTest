import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] list;

    static class Node {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[idx1].add(new Node(idx2, dist));
            list[idx2].add(new Node(idx1, dist));
        }
        bw.write(String.valueOf(dijkstra()));
        bw.flush();
    }

    static long dijkstra() {
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        que.offer(new Node(1, 0));

        while (!que.isEmpty()) {
            Node node = que.poll();
            int idx = node.to;
            int d = node.dist;

            for (Node n : list[idx]) {
                if (dist[n.to] > d + n.dist) {
                    dist[n.to] = d + n.dist;
                    que.offer(new Node(n.to, dist[n.to]));
                }
            }
        }

        return dist[N];
    }
}
