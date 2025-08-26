import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, P, X, ans;
    static int[][] num;
    static int[] xarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        num = new int[][]{
                {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
                {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
                {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
                {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
                {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
                {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
                {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
                {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
                {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
                {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
        };


        // 1이상, P개 이하의 반전이 있어야 함
        // 바뀐 숫자는 N 이하의 숫자

        xarr = new int[K];
        int temp = X;
        for (int i = K - 1; i >= 0; i--) {
            xarr[i] = temp % 10;
            temp /= 10;
        }

        dfs(0, 0, 0);

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static void dfs(int pos, int cnt, int number){
        if (cnt > P) return;

        if(pos==K){
            if (number >= 1 && number <= N && number != X && cnt >= 1 && cnt <= P) {
                ans++;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            int cost = num[xarr[pos]][i];
            dfs(pos + 1, cnt + cost, number * 10 + i);
        }
    }
}
