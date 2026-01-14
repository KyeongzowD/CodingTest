import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }
        Long answer = 0L;

        while (queue.size() > 1) {
            Long a = queue.poll(), b = queue.poll();
            answer += a + b;
            queue.offer(a + b);
        }
        System.out.println(answer);
    }
}
