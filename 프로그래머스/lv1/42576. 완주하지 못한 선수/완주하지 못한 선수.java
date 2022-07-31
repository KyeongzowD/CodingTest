import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        System.out.println();
        Arrays.sort(completion);
        for(int i=0;i<completion.length;i++)
        {
            if(participant[i].equals(completion[i])){
                
            }else{
                answer= participant[i];
                break;
            }                
        }
        if(answer.equals(""))
        {
            answer=participant[participant.length-1];
        }
        return answer;
    }
}