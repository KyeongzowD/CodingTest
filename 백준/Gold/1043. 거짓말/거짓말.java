import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람수
        int M = Integer.parseInt(st.nextToken()); // 파티수
        boolean[] knowFactParty = new boolean[M]; // 이미 알고 있는 파티 -> true

        st = new StringTokenizer(br.readLine());
        int fact = Integer.parseInt(st.nextToken());
        Set<Integer> facts = new LinkedHashSet<>();
        if (fact!=0) {
            for (int i = 0; i < fact; i++){
                int j = Integer.parseInt(st.nextToken());
                facts.add(j);
            }
        }else {
            System.out.print(M);
            return;
        }

        int ans=M; // 과장된 이야기를 할 수 있는 파티의 최대값

        Queue<Integer> que = new ArrayDeque<>();
        List<List<Integer>> partyMembers = new ArrayList<>();
        for (int p = 0; p < M; p++) {
            partyMembers.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int member = Integer.parseInt(st.nextToken());
            for (int i = 0; i < member; i++) {
                int pm = Integer.parseInt(st.nextToken());
                partyMembers.get(p).add(pm);
                if(facts.contains(pm)&&!knowFactParty[p]){
                    knowFactParty[p] = true;
                    que.offer(p);
                }
            }
        }

        while (!que.isEmpty()) {
            ans--;
            int party = que.poll();
            int len = partyMembers.get(party).size();

            for (int i = 0; i < len; i++) {
                facts.add(partyMembers.get(party).get(i)); // 사실을 아는 사람들 추가
            }
            
            for (int i = 0; i < M; i++) { // 팀에 아는 사람이 있는지
                if(knowFactParty[i]) continue;
                for (int j = 0; j < partyMembers.get(i).size(); j++) { // 아는 사람인지
                    if (facts.contains(partyMembers.get(i).get(j)) && !knowFactParty[i]) {
                        knowFactParty[i] = true;
                        que.offer(i);
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
