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

        int k = N - 2; // 기름값이 싼 도시의 위치
        int arrival = len[N - 2]; // 현재 위치에서 도착지까지의 거리
        for (int i = N - 2; i > 0; i--) {
            if (soil[i] >= soil[i - 1]) { // 이전 도시가 기름값이 더 저렴할 경우
                k = soil[i - 1];
                arrival += len[i - 1];
            } else { // 이전 도시가 기름값이 더 비쌀 경우
                ans += k * arrival; // 비싸지기 때문에 저렴했던 기름값 미리 계산
                totalLen -= arrival; // 남은 거리에서 계산한 거리 제거
                k = i - 1;
                arrival = 0;
            }
        }
        ans += soil[0] * totalLen;

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
