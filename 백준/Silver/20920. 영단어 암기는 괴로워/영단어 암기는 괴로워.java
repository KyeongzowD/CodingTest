import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new LinkedHashMap<>(); // key값에는 단어가 오고, value에는 빈도수가 저장
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) { // 글자수의 길이가 M이상이어야 함
                if(map.containsKey(word)) map.replace(word, map.get(word) + 1);
                else map.put(word, 1);
            }
        }

        Set<Integer> set = new HashSet<>(map.values()) ;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder()); // 빈도수 내림차순

        while (!list.isEmpty()) {
            int v = list.get(0); // 가장 많은 빈도수

            List<String> words = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(v)) {
                    words.add(entry.getKey());
                }
            }

            words.sort((a, b) -> {
                if (a.length() != b.length()) {
                    return b.length() - a.length(); // 길이 내림차순
                } else {
                    return a.compareTo(b);         // 길이가 같으면 알파벳순(오름차순)
                }
            });

            for (int i = 0; i < words.size(); i++) { // 순서대로 출력문에 입력
                sb.append(words.get(i)).append("\n");
            }

            list.remove(0);
        }


        bw.write(sb.toString());
        bw.flush();
    }
}
