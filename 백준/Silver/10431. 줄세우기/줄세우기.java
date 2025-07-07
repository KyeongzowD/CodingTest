import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        for (int i = 0; i < P; i++) {
            int ans=0;
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            for (int j = 0; j < 20; j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if(arr[j] < arr[k]) ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}