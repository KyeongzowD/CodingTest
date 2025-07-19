import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long totalLen;
    static int[] len;
    static int[] soil;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        len = new int[N - 1]; // 도로의 길이
        soil = new int[N]; // 각 도시의 리터 당 가격
        totalLen = 0;
        long ans = 0; // 최소 비용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) { // 도로의 길이 입력
            len[i] = Integer.parseInt(st.nextToken());
            totalLen += len[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 리터 당 가격 입력
            soil[i] = Integer.parseInt(st.nextToken());
        }

        int k = soil[0]; // 기름값이 싼 도시의 위치
        int arrival = len[0]; // 계산할 거리
        for (int i = 1; i < N - 1; i++) {
            if (k < soil[i]) { // 기름값이 비싸질 경우, 현재의 기름으로 다름 기름값을 계산
                arrival += len[i]; // 함께 계산할 거리 합산
            }else { // 값이 저렴해질 경우, 여태의 거리 계산과 k값 변경
                ans += k * arrival;
                k = soil[i];
                arrival = len[i];
            }
        }
        ans += k * arrival;

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}