import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> ladder, snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ladder = new HashMap<>(); // 올라가는 사다리
        snake = new HashMap<>(); // 내려가는 뱀

        N = Integer.parseInt(st.nextToken()); // 사다리 수
        M = Integer.parseInt(st.nextToken()); // 뱀 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder.put(from, to);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake.put(from, to);
        }

        bw.write(String.valueOf(dijkstra()));
        bw.flush();
    }

    static int dijkstra() {
        // int[] arr => idx, 이동한 수
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[101];
        Arrays.fill(dist, 10_000);
        dist[0] = 0; dist[1] = 0;
        que.offer(new int[]{1, 0});

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int idx = arr[0]; int cost = arr[1];
            if (idx == 100) break;

            for (int i = 1; i <= 6 && idx + i < 101; i++) {

                if (ladder.containsKey(idx + i)) {
                    int to = ladder.get((idx + i));
                    if (dist[to] > cost + 1) {
                        dist[to] = cost + 1;
                        que.offer(new int[]{to, cost + 1});
                    }
                }

                else if (snake.containsKey(idx + i)) {
                    int to = snake.get(idx + i);
                    if (dist[to] > cost + 1) {
                        dist[to] = cost + 1;
                        que.offer(new int[]{to, cost + 1});
                    }
                }

                else if (cost + 1 < dist[idx + i]) {
                    dist[idx + i] = cost + 1;
                    que.offer(new int[]{idx + i, cost + 1});
                }
            }
        }
        return dist[100];
    }
}
