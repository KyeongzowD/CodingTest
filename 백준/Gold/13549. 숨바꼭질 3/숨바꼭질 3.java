import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        visited = new boolean[K * 2];

        if (K <= N) { // 동생의 위치가 0에 더 가까울 때
            ans = N - K;
        } else { // 수빈이의 위치가 0에 더 가까울 때
            ans = K - N;
            BFS(N, K);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void BFS(int n, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 가중치 우선순위 큐
        que.offer(new int[]{n, 0});

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            if (arr[0] == k) {
                ans = arr[1];
                return;
            }
            visited[arr[0]] = true;

            if (arr[0] + 1 <= k * 2 - 1 && !visited[arr[0] + 1] && arr[1] + 1 < ans)  que.offer(new int[]{arr[0] + 1, arr[1] + 1});
            if (arr[0] - 1 >= 0 && !visited[arr[0] - 1] && arr[1] + 1 < ans)  que.offer(new int[]{arr[0] - 1, arr[1] + 1});
            if (arr[0] < k && !visited[arr[0] * 2] && arr[1] < ans) que.offer(new int[]{arr[0] * 2, arr[1]});
        }
    }
}