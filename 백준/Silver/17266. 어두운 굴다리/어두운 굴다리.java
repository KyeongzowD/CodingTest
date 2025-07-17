import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0; // 가로등의 최소 높이
        int N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int maxLen = x * 2; // 최대 간격
        for (int i = 1; i < M; i++) {
            int y = Integer.parseInt(st.nextToken());
            maxLen = Math.max(y - x, maxLen);
            x = y;
        }
        maxLen = Math.max((N - x) * 2, maxLen);
        answer = maxLen % 2 == 0 ? maxLen / 2 : maxLen / 2 + 1;

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
