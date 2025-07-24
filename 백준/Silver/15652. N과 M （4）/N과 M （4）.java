import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dfs(i, 1, String.valueOf(i));
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int i, int depth, String ans) {
        if (depth == M) {
            sb.append(ans).append("\n");
            return;
        }
        for (int j = i; j <= N; j++) {
            dfs(j, depth + 1, ans+" "+j);
        }
    }
}