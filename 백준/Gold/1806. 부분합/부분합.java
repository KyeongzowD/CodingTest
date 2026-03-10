import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        long sum = 0;
        int minLen = N + 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int j = Integer.parseInt(st.nextToken());
            numbers[i] = j;
            sum += j;

            if (j >= S) {
                System.out.print(1);
                return;
            }
        }

        if (sum < S) {
            System.out.print(0);
            return;
        }
        sum = 0;
        int left = 0;
        for (int right = 0; right < N; right++) {
            sum += numbers[right];

            while (sum >= S) {
                minLen = Math.min(minLen, right - left + 1);
                sum-=numbers[left++];
            }
        }
        System.out.print(minLen);
    }
}
