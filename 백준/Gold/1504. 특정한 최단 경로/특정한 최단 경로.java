import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v, dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
    static int N, E;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[n].add(new Node(m, dist));
            list[m].add(new Node(n, dist));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int ans = dijkstra(v1, v2);
        if (ans != -1) {
            int len1 = dijkstra(1, v1);
            int len2 = dijkstra(v2, N);
            int len3 = dijkstra(1, v2);
            int len4 = dijkstra(v1, N);
            if(len1==-1||len2==-1||len3==-1||len4==-1)
                ans = -1;
            else
                ans += Math.min(len1 + len2, len3 + len4);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        que.offer(new Node(start, 0));
        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        while (!que.isEmpty()) {
            Node node = que.poll();
            int to = node.v;

            if (dists[to] < node.dist) continue;

            for (Node next : list[to]) {
                if (dists[next.v] > dists[to] + next.dist) {
                    dists[next.v] = dists[to] + next.dist;
                    que.offer(new Node(next.v, dists[next.v]));
                }
            }
        }
        return dists[end] == Integer.MAX_VALUE ? -1 : dists[end];
    }
}
