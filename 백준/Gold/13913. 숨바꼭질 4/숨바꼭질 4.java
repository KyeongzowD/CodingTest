import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] len;
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int idx, dist;
        String string;

        public Node(int idx, int dist, String string) {
            this.idx = idx;
            this.dist = dist;
            this.string = string;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        len = new int[K * 2];

        if (K <= N) {
            sb.append(N - K).append("\n");
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            bw.write(sb.toString());
            bw.flush();
            return;
        }
        bw.write(func());
        bw.flush();
    }

    static String func() {
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        Arrays.fill(len, 1_000_000);
        len[N] = 0;
        que.offer(new Node(N, 0, ""));

        while (!que.isEmpty()) {
            Node node = que.poll();
            int idx = node.idx, dist = node.dist;
            String string = node.string;

            if (idx == K) {
                sb.append(dist).append("\n").append(string).append(K);
                return sb.toString();
            }

            if (idx + 1 <= K && len[idx] < len[idx + 1] + 1) {
                len[idx + 1] = dist + 1;
                que.offer(new Node(idx + 1, dist + 1, string + idx + " "));
            }
            if (idx - 1 >= 0 && len[idx] < len[idx - 1] + 1) {
                len[idx - 1] = dist + 1;
                que.offer(new Node(idx - 1, dist + 1, string + idx + " "));
            }
            if (idx < K && len[idx] < len[idx * 2] + 1) {
                len[idx * 2] = dist + 1;
                que.offer(new Node(idx * 2, dist + 1, string + idx + " "));
            }
        }
        return ""; // 도달 안함
    }
}
