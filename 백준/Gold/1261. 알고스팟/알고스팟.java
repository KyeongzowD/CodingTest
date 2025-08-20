import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static boolean[][] map, visited;
    static int[] dirY = {-1, 0, 1, 0};
    static int[] dirX = {0, -1, 0, 1};
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];
        for (int[] arr:dist) Arrays.fill(arr, 1_000_000);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '1')
                    map[i][j] = true; // true일 경우 벽
            }
        }
        dijkstra();
        bw.write(String.valueOf(dist[N - 1][M - 1]));
        bw.flush();
    }

    static void dijkstra() {
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        dist[0][0] = 0;
        que.offer(new int[]{0, 0, 0});

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            int y = arr[0], x = arr[1], cost = arr[2];
            if (y == N - 1 && x == M - 1) return;
            visited[y][x] = true;

            for (int d = 0; d < 4; d++) {
                int dy = y + dirY[d];
                int dx = x + dirX[d];

                if (dy >= 0 && dy < N && dx >= 0 && dx < M && !visited[dy][dx]) { //범위 내 존재
                    if (map[dy][dx]) {
                        if (dist[dy][dx] > cost + 1){
                            dist[dy][dx] = cost + 1;
                            que.offer(new int[]{dy, dx, dist[dy][dx]});
                        }
                    } else {
                        if (dist[dy][dx] > cost) {
                            dist[dy][dx] = cost;
                            que.offer(new int[]{dy, dx, dist[dy][dx]});
                        }
                    }
                }
            }
        }
    }
}
