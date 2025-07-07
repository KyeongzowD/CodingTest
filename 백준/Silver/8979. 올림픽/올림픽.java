import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;

        int[][] arr = new int[N][3];
        int ans = 1;

        // 메달 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken())-1;
            arr[j][0] = Integer.parseInt(st.nextToken());
            arr[j][1] = Integer.parseInt(st.nextToken());
            arr[j][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if(i==K) continue;

            if(arr[i][0]>arr[K][0]){ // 금메달 비교 (다른 팀이 더 많을 경우)
                ans++;
            } else if (arr[i][0]==arr[K][0]) { // 금메달 비교 (같을 경우)
                if (arr[i][1]>arr[K][1]){ // 은메달 비교 (다른 팀이 더 많을 경우)
                    ans++;
                } else if (arr[i][1]==arr[K][1]) { // 은메달 비교 (같을 경우)
                    if (arr[i][2]>arr[K][2]){ // 동메달 비교 (다른 팀이 더 많을 경우)
                        ans++;
                    }
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}