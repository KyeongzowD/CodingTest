import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int a = 0, b = N - 1;
        long min = arr[a] + arr[b];
        int minA = a, minB = b;

        while (a != b) {
            int sum = arr[a] + arr[b];
            if (Math.abs(sum) < Math.abs(min)) {
                minA = a; minB = b; min = sum;
            }

            if(sum>0) b--;
            else if(sum==0) break;
            else a++;
        }

        System.out.println(arr[minA] + " " + arr[minB]);
    }
}
