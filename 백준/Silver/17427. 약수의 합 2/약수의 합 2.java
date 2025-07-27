import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long ans = N;
        for (int i = 2; i <= N; i++) {
            ans += (long)(N / i) * i;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
