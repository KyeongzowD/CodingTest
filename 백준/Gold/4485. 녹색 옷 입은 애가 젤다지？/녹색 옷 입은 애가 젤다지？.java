import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        N = Integer.parseInt(br.readLine());
        while (N != 0) {
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(tc++).append(": ").append(dijkstra()).append("\n");
            N = Integer.parseInt(br.readLine());
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static int dijkstra() {
        int[][] map = new int[N][N];
        for (int[] m:map) Arrays.fill(m, Integer.MAX_VALUE);
        map[0][0] = arr[0][0];

        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        que.offer(new int[]{0, 0, arr[0][0]});

        while (!que.isEmpty()) {
            int[] node = que.poll();
            if (node[2] != map[node[0]][node[1]]) continue;

            for (int d = 0; d < 4; d++) {
                int dy = node[0] + dirY[d];
                int dx = node[1] + dirX[d];

                if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
                    if (map[dy][dx] < arr[dy][dx] + arr[node[0]][node[1]] || map[dy][dx] != Integer.MAX_VALUE) {
                        continue;
                    }
                    map[dy][dx] = arr[dy][dx] + map[node[0]][node[1]];
                    que.offer(new int[]{dy, dx, map[dy][dx]});
                }
            }
        }
        return map[N - 1][N - 1];
    }
}
