import java.io.*;

public class Main {
    static int min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            max = 0;

            for (int i = 0; i <= w.length() - k; i++) {
                func(w.substring(i), k);
            }

            if (max != 0) {
                sb.append(min).append(" ").append(max).append("\n");
            } else {
                sb.append(-1).append("\n");
            }

        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void func(String s, int k) {
        if (s.length() < k) return;
        int cnt = 0;

        char c = s.charAt(0);
        // 현재 문자를 기준으로 계산
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) cnt++;
            if (cnt == k) {
                int len = i + 1;
                if (len < min) min = len;
                if (len > max) max = len;
                return;
            }
        }
    }
}
