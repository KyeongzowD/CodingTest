import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(goodNum(N, i, arr[i])) ans++;
        }
        System.out.println(ans);
    }

    static boolean goodNum(int N, int idx, int target) {
        int left = 0, right = N-1;

        while (left < right) {
            int t = arr[left] + arr[right];
            if (t == target) {
                if (idx == left) {
                    left++; continue;
                } else if (idx == right) {
                    right--; continue;
                }
                return true;
            } else if (t < target) {
                left++;
            } else if (t > target) {
                right--;
            }
        }
        return false;
    }
}
