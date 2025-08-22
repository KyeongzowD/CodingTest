import java.util.*;

class Solution {
    static List<String> list;
    static int l;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        // 공항의 수는 티켓 수 +1
        l = tickets.length + 1;
        list = new ArrayList<>();
        
        dfs("ICN", tickets,"");
        
        Collections.sort(list);
        String s = list.get(0);
        answer = new String[l];
        
        for(int i = 0; i < l; i++){
            answer[i] = s.substring(i * 3, i * 3 + 3);
        }
        
        return answer;
    }
    
    static void dfs(String from, String[][] tickets, String sb){ 
        sb += from;
        if(sb.length() == l * 3) {
            list.add(sb);
            return;
        }
        
        for (int i = 0; i < l - 1; i++){
            if (tickets[i][0].equals(from)){
                tickets[i][0]="";
                dfs(tickets[i][1], tickets, sb);
                tickets[i][0]=from;
            }
        }
    }
}