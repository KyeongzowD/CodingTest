import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] cable;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cable = new int[K];

        int maxLen = 0;
        for (int i = 0; i < K; i++) {
            int len = Integer.parseInt(br.readLine());
            cable[i] = len;
            if (len > maxLen) maxLen = len; // 자를 수 있는 최대 길이의 상한
        }

        System.out.println(binarySearchMaxLength(maxLen));
    }

    // 길이의 최댓값을 이분 탐색으로 찾음
    static int binarySearchMaxLength(int right) {
        long l = 1, r = right;  // 길이는 1 이상
        int answer = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2; // 오버플로 방지형 mid
            long cnt = 0;

            // mid 길이로 잘랐을 때 만들 수 있는 개수
            for (int i = 0; i < K; i++) {
                cnt += (cable[i] / mid);
                if (cnt >= N) break; // 조기 종료(상수 시간 절약)
            }

            if (cnt >= N) {       // mid로 N개 이상 만들 수 있으면 더 길게 시도
                answer = (int) mid;
                l = mid + 1;
            } else {               // 부족하면 더 짧게
                r = mid - 1;
            }
        }
        return answer;
    }
}
