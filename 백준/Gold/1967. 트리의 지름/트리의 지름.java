import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static int ans;
    static class Node {
        int no, dist;

        public Node(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        ans = 0;

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken()); // 부모 노드
            int from = Integer.parseInt(st.nextToken()); // 자식 노드
            int dist = Integer.parseInt(st.nextToken()); // 가중치
            list[to].add(new Node(from, dist));
        }

        dfs(1);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int dfs(int i) {
        int best1 = 0, best2 = 0;

        for (Node node : list[i]) {
            int down = dfs(node.no) + node.dist; // 자식 노드의 가중치와 자식노드가 포함한 가중치

            if (down > best1) {
                best2 = best1; best1 = down;
            } else if (down > best2) {
                best2 = down;
            }
        }
        ans = Math.max(ans, best1 + best2);

        return best1;
    }
}
