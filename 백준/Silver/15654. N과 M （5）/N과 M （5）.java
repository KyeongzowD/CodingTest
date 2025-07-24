import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            dfs(i, 1, String.valueOf(arr[i]));
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int i, int depth, String ans) {
        visited[i] = true;
        if (depth == M) {
            sb.append(ans).append("\n");
            visited[i] = false;
            return;
        }

        for (int j = 0; j < N; j++) {
            if(!visited[j]){ // 방문 안했을 경우 depth
                dfs(j, depth+1, ans+" "+arr[j]);
            }
        }
        visited[i] = false;
    }
}
