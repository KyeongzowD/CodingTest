import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken())) {
                case 1 :
                    que.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 2 :
                    if (que.isEmpty()) sb.append("-1\n");
                    else sb.append(que.pollLast()).append("\n");
                    break;
                case 3 :
                    sb.append(que.size()).append("\n");
                    break;
                case 4 :
                    if (que.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 5 :
                    if (que.isEmpty()) sb.append("-1\n");
                    else sb.append(que.peekLast()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
