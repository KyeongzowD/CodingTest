import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int max = 0, min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        M = Integer.parseInt(br.readLine());
        min = Math.min(M / N, min);

        bw.write(String.valueOf(binarySearch(min, max)));
        bw.flush();
    }

    static int binarySearch(int min, int max) {
        int left = min, right = max, ans = min;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int total = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) total += mid;
                else total += arr[i];
            }

            if (total > M) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
