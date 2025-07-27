import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            que.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N; i++) {
            sb.append(que.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}