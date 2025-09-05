import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];
        int x = -1, y = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    y = i; x = j;
                }
            }
        }
        bfs(y, x);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && dist[i][j] == 0)
                    sb.append("-1 ");
                else
                    sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void bfs(int y, int x) {
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        int[] dirY = {-1, 0, 1, 0}, dirX = {0, -1, 0, 1};
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y, x});

        while (!que.isEmpty()) {
            int[] node = que.poll();
            int i = node[0], j = node[1];

            for (int d = 0; d < 4; d++) {
                int dy = i + dirY[d], dx = j + dirX[d];
                if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx] && arr[dy][dx] == 1) {
                    dist[dy][dx] = dist[i][j] + 1;
                    visited[dy][dx] = true;
                    que.offer(new int[]{dy, dx});
                }
            }
        }
    }
}
