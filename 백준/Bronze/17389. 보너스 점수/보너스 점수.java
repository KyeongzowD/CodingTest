import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int answer = 0;

        for (int i = 0, k = 0; i < N; i++) {
            if(S.charAt(i)=='O'){
                answer += i + 1 + (k++);
            }else {
                k = 0;
            }
        }
        System.out.println(answer);
    }
}
