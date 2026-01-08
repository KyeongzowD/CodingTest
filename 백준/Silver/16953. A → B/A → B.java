import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int answer = 1;

        while (B != A && B > A) {
            if (B % 2 == 1) { 
                if (B % 10 != 1) {
                    answer = -1;
                    break;
                }
                B = B / 10;
            } else B /= 2;

            answer++;
        }
        if (A > B) answer = -1;

        System.out.println(answer);
    }
}
