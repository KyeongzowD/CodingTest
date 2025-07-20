import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][2]; // dp[N][0]은 1개차의 합, dp[N][1]은 2개 차의 합
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            bw.write(String.valueOf(arr[0])); bw.flush(); return;
        } else if (N == 2) {
            bw.write(String.valueOf(arr[0]+arr[1])); bw.flush(); return;
        }

        dp[0][0] = arr[0]; dp[0][1] = arr[0];
        dp[1][0] = arr[1] + arr[0]; dp[1][1] = arr[1];

        for (int i = 2; i < N; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
        }
        bw.write(String.valueOf(Math.max(dp[N - 1][0], dp[N - 1][1])));
        bw.flush();
    }
}