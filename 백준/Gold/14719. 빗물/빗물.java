import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] block = new boolean[H][W];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j = 0; j < h; j++) {
                block[j][i] = true;
            }
        }

        for (int i = 0; i < H; i++) {
            int idx = -1;
            for (int j = 0; j < W; j++) {
                if (block[i][j]){
                    if (idx == -1) {
                        idx = j;
                    } else {
                        ans += j - idx - 1;
                        idx = j;
                    }
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
