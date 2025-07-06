import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[] arr = new boolean[21];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    arr[Integer.parseInt(st.nextToken())] = true;
                    break;

                case "remove":
                    arr[Integer.parseInt(st.nextToken())] = false;
                    break;

                case "check":
                    if(arr[Integer.parseInt(st.nextToken())])
                        bw.write("1");
                    else
                        bw.write("0");
                    bw.newLine();
                    break;

                case "toggle":
                    int x=Integer.parseInt(st.nextToken());
                    arr[x]= !arr[x];
                    break;

                case "all":
                    for (int j = 0; j < 21; j++) {
                        arr[j] = true;
                    }
                    break;

                case "empty":
                    for (int j = 0; j < 21; j++) {
                        arr[j] = false;
                    }
                    break;
            }
        }
        bw.flush();
    }
}
