import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K = K == N ? K - 1 : K;

        int[] name = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            name[i] = s.length();
        }

        long ans = 0;
        int[] same = new int[21]; // 최대 20자 임을 명시
        for (int i = 0; i <= K; i++) {
            ans += same[name[i]]++;
        }

        for (int i = 0; i + K + 1 < N; i++) {
            same[name[i]]--;
            ans += same[name[i + K + 1]]++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
