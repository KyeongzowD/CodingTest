import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 1, right = arr[N - 1] - arr[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 1, home = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] - home >= mid) {
                    cnt++;
                    home = arr[i];
                }
            }

            if (cnt >= C) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
