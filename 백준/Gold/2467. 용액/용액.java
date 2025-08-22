import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0, b = N - 1;
        int min = arr[a] + arr[b];
        sb.append(arr[a]).append(" ").append(arr[b]);
        while (true) {
            if (arr[a] + arr[b] < 0) { // 음수일 경우
                a++;
            } else { // 양수일 경우
                b--;
            }

            if (a == b) break;
            int v = arr[a] + arr[b];

            if (Math.abs(min) > Math.abs(v)) {
                min = v;
                sb.setLength(0);
                sb.append(arr[a]).append(" ").append(arr[b]);
            }
            if (min == 0)
                break;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
