import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int P = Integer.parseInt(br.readLine());
            String score = br.readLine();
            StringTokenizer st = new StringTokenizer(score);

            Hashtable<Integer, Integer> arr = new Hashtable<>();
            for (int j = 0; j < P; j++) {
                int teamNumber = Integer.parseInt(st.nextToken());
                if(arr.get(teamNumber)==null)
                    arr.put(teamNumber, 1);
                else
                    arr.replace(teamNumber,arr.get(teamNumber)+1);
            }

            arr.entrySet().removeIf(entry -> entry.getValue() != 6);

            arr.replaceAll((k, v) -> 0); // 인원수를 모두 0으로 만들고, 값을 점수로 바꿔서 사용

            st = new StringTokenizer(score);
            int cnt = 0;

            Hashtable<Integer, Integer> four = new Hashtable<>();
            while (st.hasMoreTokens()) { // 4명 점수 함산하는 반복문
                int teamNum = Integer.parseInt(st.nextToken());
                if (arr.containsKey(teamNum)) {
                    cnt++;
                    if (!four.containsKey(teamNum))  four.put(teamNum, 0);

                    if (four.get(teamNum) < 4) { // 모두 더하는게 아니라 상위 4명만 합산
                        four.replace(teamNum, four.get(teamNum) + 1);
                        arr.replace(teamNum, arr.get(teamNum) + cnt);
                    }
                }
            }

            int winner = 0; // 이긴 팀 이름
            int minValue = Integer.MAX_VALUE; // 이긴 팀 점수
            for (Map.Entry<Integer, Integer> entry : arr.entrySet()) {
                if (entry.getValue() < minValue) { // 더 낮은 점수의 팀이 winner
                    minValue = entry.getValue();
                    winner = entry.getKey();
                } else if (entry.getValue() == minValue) { // 점수가 동일할 경우, 5번째로 들어온 사람의 순서로 판단
                    st = new StringTokenizer(score);
                    int a = 0, b = 0; //a는 이기고 있던 팀, b는 반복문에서 비교하는 팀
                    while (a < 5 && b < 5) {
                        int n = Integer.parseInt(st.nextToken());
                        if (n == winner) a++;
                        else if (n == entry.getKey()) b++;
                    }
                    winner = a == 5 ? winner : entry.getKey();
                }
            }
            sb.append(winner).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
