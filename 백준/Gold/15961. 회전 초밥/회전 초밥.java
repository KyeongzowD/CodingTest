import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 - 초밥의 종류
        int ans = 0; // 최대 몇가지의 초밥


        int[] plate = new int[N];
        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d + 1];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if(sushi[plate[i]]++==0) cnt++;
        }
        ans = sushi[c] == 0 ? 1 + cnt : cnt;

        for (int i = 0; i < N; i++) { //i는 시작점
            if (--sushi[plate[i]] == 0) cnt--;
            if (sushi[plate[(i + k) % N]]++ == 0) cnt++;

            ans = Math.max(ans, sushi[c] == 0 ? 1 + cnt : cnt);
            if (ans == k + 1) break;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
