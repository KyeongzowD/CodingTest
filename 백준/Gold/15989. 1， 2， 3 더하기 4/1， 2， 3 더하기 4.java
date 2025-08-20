import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long cnt = 0;

            while (n > 0) {
                cnt += (n + 2) / 2;
                n -= 3;
            }
            if (n == 0) cnt++;
            sb.append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close(); bw.close();
    }
}
