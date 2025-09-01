import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans += Long.parseLong(st.nextToken());
        ans += Long.parseLong(st.nextToken());
        ans += Long.parseLong(st.nextToken());

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
