import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int ans = 0;

        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        if (game.equals("Y")) {
            ans = list.size();
        } else if (game.equals("F")) {
            ans = list.size()/2;
        }else {
            ans = list.size()/3;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
