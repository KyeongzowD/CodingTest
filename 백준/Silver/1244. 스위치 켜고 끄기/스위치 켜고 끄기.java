import java.io.*;
import java.util.*;

public class Main {
    static boolean[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().equals("1");
        }

        int people = Integer.parseInt(br.readLine());
        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) boy(number);
            else girl(number-1);
        }

        for (int i = 0; i < N; i++) {
            if(arr[i]) sb.append("1 ");
            else sb.append("0 ");
            
            if ((i + 1) % 20 == 0) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void boy(int a) {
        for (int i = a - 1; i < N; i += a) {
            arr[i] = !arr[i];
        }
    }

    static void girl(int a) {
        arr[a] = !arr[a];
        for (int i = 1; ; i++) {
            if (a - i >= 0 && a + i < N && arr[a - i] == arr[a + i]) {
                arr[a-i] = !arr[a-i];
                arr[a+i] = !arr[a+i];
            }else break;
        }
    }
}
