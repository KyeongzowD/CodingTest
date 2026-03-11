import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int len1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[len1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int len2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[len2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        makeList(list1, arr1, len1);
        makeList(list2, arr2, len2);

        Collections.sort(list1);
        Collections.sort(list2);

        len1 = list1.size();
        long ans = 0;
        for (int i = 0; i < len1; i++) {
            int target = T - list1.get(i);
            int lower = lowerBound(list2, target);
            int upper = upperBound(list2, target);

            ans += (upper - lower);
        }
        System.out.println(ans);
    }

    static int lowerBound(List<Integer> list, int target) { //target이 나오는 첫 위치
        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target)  right = mid;
            else  left = mid + 1;
        }
        return left;
    }

    static int upperBound(List<Integer> list, int target) { //target 초과가 나오는 첫 위치
        int left = 0, right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) <= target) left = mid + 1;
            else  right = mid;
        }
        return left;
    }

    static void makeList(List<Integer> list, int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}
