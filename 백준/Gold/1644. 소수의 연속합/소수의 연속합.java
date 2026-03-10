import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N + 1];
        prime[0] = true; prime[1] = true;
        if (N == 1) {
            System.out.print(0);
            return;
        } else if (N == 2) {
            System.out.println(1);
            return;
        }
        prime[2] = false; prime[3] = false;

        for (int i = 2; i < N + 1; i++) {
            for (int j = i; (long)i * (long)j <(long)(N + 1); j++) {
                prime[i * j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < N + 1; i++) {
            if (!prime[i]) list.add(i);
        }

        Integer[] primeNumber = list.toArray(new Integer[0]);
        int len = primeNumber.length;
        long sum = 0;
        int left = 0, cnt = 0;

        for (int right = 0; right < len; right++) {
            sum += primeNumber[right];

            while (sum > N) {
                sum -= primeNumber[left++];
            }
            if (sum == N) cnt++;
        }

        System.out.print(cnt);
    }
}
