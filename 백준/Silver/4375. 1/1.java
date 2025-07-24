import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null && !input.trim().isEmpty()) {
            int N = Integer.parseInt(input.trim());

            int k = 1 % N;
            int ans = 1;

            while (k != 0) {
                k = (k * 10 + 1) % N; // 나머지로만 계산
                ans++;
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
