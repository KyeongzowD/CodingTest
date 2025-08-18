import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, D, ans;
    static int[][] arr, to, from;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // i
        M = Integer.parseInt(st.nextToken()); // j
        T = Integer.parseInt(st.nextToken()); // 현재의 위치에서 T보다 큰 차이가 나는 값과는 이동할 수 없음
        D = Integer.parseInt(st.nextToken()); // 왕복 시간
        arr = new int[N][M]; // 높이
        to = new int[N][M]; // 지점까지 도착하는데 걸린 시간
        from = new int[N][M]; // 지점애서 호텔까지 도달하는데 걸린 시간

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) < 92) { // 대문자 65-90
                    arr[i][j] = str.charAt(j) - 65;
                }else { // 소문자  97-122
                    arr[i][j] = str.charAt(j) - 71;
                }
            }
        }
        ans = 0; //최대 높이
        dijkstra1();
        dijkstra2();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (to[i][j] + from[i][j] <= D && arr[i][j] > ans)
                    ans = arr[i][j];
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void dijkstra1() { // to 배열을 계산하기 위한 함수
        // (0,0)에서 시작해서 같거나 낮으면 1, 높으면 제곱수로 계산
        for (int[] array : to) Arrays.fill(array, 1_000_000_000);
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // i, j,  time(a[2]) 시간순으로 정렬
        to[0][0] = 0; // 시작점은 시간이 안걸림
        que.offer(new int[]{0,0,0});

        while (!que.isEmpty()) {
            int[] node= que.poll();
            if (node[2] != to[node[0]][node[1]]) continue; // 우선순위 큐가 최소 시간의 수를 먼저 제공하기 때문에, 다른 시간은 고려하지 않아도 됨

            for (int d = 0; d < 4; d++) {
                int dy = node[0] + dirY[d], dx = node[1] + dirX[d];
                if (dy >= 0 && dy < N && dx >= 0 && dx < M && Math.abs(arr[node[0]][node[1]] - arr[dy][dx]) <= T) {
                    int dist = 1;
                    if (arr[dy][dx] > arr[node[0]][node[1]]) { // 제곱수
                        int p = arr[dy][dx] - arr[node[0]][node[1]];
                        dist = p * p;
                    }
                    if (to[dy][dx] > dist + to[node[0]][node[1]] && dist + to[node[0]][node[1]] <= D) {
                        to[dy][dx] = dist + to[node[0]][node[1]];
                        que.offer(new int[]{dy, dx, to[dy][dx]});
                    }
                }
            }
        }
    }

    static void dijkstra2() { // from 배열을 계산하기 위한 함수
        // (0,0)에서 시작해서 같거나 높으면 1, 낮으면 제곱수로 계산 (1번 함수와 반대로 계산)
        for (int[] array : from) Arrays.fill(array, 1_000_000_000);
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // i, j,  time(a[2]) 시간순으로 정렬
        from[0][0] = 0; // 시작점은 시간이 안걸림
        que.offer(new int[]{0,0,0});

        while (!que.isEmpty()) {
            int[] node= que.poll();
            if (node[2] != from[node[0]][node[1]]) continue; // 우선순위 큐가 최소 시간의 수를 먼저 제공하기 때문에, 다른 시간은 고려하지 않아도 됨

            for (int d = 0; d < 4; d++) {
                int dy = node[0] + dirY[d], dx = node[1] + dirX[d];
                if (dy >= 0 && dy < N && dx >= 0 && dx < M && Math.abs(arr[node[0]][node[1]] - arr[dy][dx]) <= T) {
                    int dist = 1;
                    if (arr[dy][dx] < arr[node[0]][node[1]]) { // 제곱수
                        int p = arr[dy][dx] - arr[node[0]][node[1]];
                        dist = p * p;
                    }
                    if (from[dy][dx] > dist + from[node[0]][node[1]] && dist + from[node[0]][node[1]] <= D) {
                        from[dy][dx] = dist + from[node[0]][node[1]];
                        que.offer(new int[]{dy, dx, from[dy][dx]});
                    }
                }
            }
        }
    }
}
