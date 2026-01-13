import java.io.*;
import java.util.*;

public class Main {
    static class Score {
        int s1, s2;

        Score(int s1, int s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Score> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                list.add(new Score(s1, s2));
            }
            int i=0;
            list.sort((o1, o2) -> o1.s1 - o2.s1);
            Score score = list.get(i);
            while (i != list.size()) {
                int j = i + 1;
                for (; j < list.size(); j++) {
                    if (list.get(j).s1 > score.s1 && list.get(j).s2 > score.s2)
                        list.remove(j--);
                    else {
                        score = list.get(j);
                        break;
                    }
                }
                i = j;
            }
            stringBuilder.append(list.size()).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
