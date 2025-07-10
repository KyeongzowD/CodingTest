import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입력받은 점수의 갯수
        int score = Integer.parseInt(st.nextToken()); // 등수 찾을 점수
        int P = Integer.parseInt(st.nextToken()); // 랭크에 올릴 수 있는 점수의 갯수

        int cnt=0;
        int rank = 1;

        if(N > 0)
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N && rank <= P; i++) {
            int scores = Integer.parseInt(st.nextToken());
            if (scores > score) {
                rank++;
            } else if (scores == score) {
                cnt++;
            }

        }
        if ((cnt + rank > P && N == P) || rank > P)
            rank = -1;

        bw.write(String.valueOf(rank));
        bw.flush();
    }
}
