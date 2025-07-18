import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        int x = Integer.highestOneBit(N);
        if(N == x) x/=2;
        if (N != 1)  ans = (N - x) * 2;
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
