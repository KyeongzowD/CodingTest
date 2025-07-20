import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>(); 

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str))
                list.add(str);
        }
        int len = list.size();
        sb.append(len).append("\n");
        Collections.sort(list);
        for (int i = 0; i < len; i++) {
            sb.append(list.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}