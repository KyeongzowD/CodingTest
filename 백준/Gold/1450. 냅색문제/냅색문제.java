import java.io.*;
import java.util.*;

public class Main {
    static long C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> leftSum = new ArrayList<>();
        List<Long> rightSum = new ArrayList<>();

        makeSum(leftSum, 0, N / 2, 0);
        makeSum(rightSum, N / 2, N, 0);

        Collections.sort(rightSum);

        long cnt = 0;
        for (Long l : leftSum) {
            cnt += search(rightSum, l);
        }

        System.out.println(cnt);
    }

    static void makeSum(List<Long> list, int idx, int end, long sum) {
        if (sum > C)  return;

        if (idx == end) {
            list.add(sum);
            return;
        }

        makeSum(list, idx + 1, end, sum + arr[idx]);
        makeSum(list, idx + 1, end, sum);
    }

    static int search(List<Long> list, long l) {
        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (l+list.get(mid) <= C) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
