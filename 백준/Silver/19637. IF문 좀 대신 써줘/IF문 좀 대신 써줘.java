import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] power = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(br.readLine());
            sb.append(name[binary(power, value)]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static int binary(int[] power, int value) {
        int left = 0, right = power.length - 1, ans = power.length;
        while (left <= right) {
            int v = (left + right) / 2; // 왼쪽 인덱스와 오른쪽 인덱스의 사이. 현재 인덱스
            if (power[v] >= value) {
                ans = v;
                right = v - 1;
            }else {
                left = v + 1;
            }
        }
        return ans;
    }
}
