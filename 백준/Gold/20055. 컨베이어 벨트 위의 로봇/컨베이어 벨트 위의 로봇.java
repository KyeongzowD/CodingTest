import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2 * N];
        robots = new boolean[N];
        int ans = 0;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            ans++;
            // 1. 벨트 회전
            int last = arr[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[N - 1] = false;
            robots[0] = false;

            // 2. 로봇 이동
            for (int i = N-1 ; i > 0; i--) {
                if (robots[i - 1] && arr[i] > 0 && !robots[i]) {
                    robots[i] = true;
                    robots[i - 1] = false;
                    arr[i]--;
                    if(arr[i]==0) cnt++;
                }
            }

            // 3. 올리는 칸에 로봇 올리기
            if (arr[0] > 0 && !robots[0]) {
                robots[0] = true;
                arr[0]--;
                if(arr[0]==0) cnt++;
            }

            // 4. 내구도가 0인 칸의 수가 K개 이상일 경우 break;
            if (cnt >= K) break;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
