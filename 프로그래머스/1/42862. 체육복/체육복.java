import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostLen=lost.length;
        int resLen=reserve.length;
        int answer = n-lostLen;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0;i<lostLen;i++){
            for(int j=0;j<resLen;j++){
                if(lost[i]==reserve[j]){
                    lost[i]=-1; reserve[j]=-1;
                    answer++;
                }
            }
        }
        
        for(int i=0;i<lostLen;i++){
            if(lost[i]==-1) continue;
            for(int j=0;j<resLen;j++){
                if(Math.abs(lost[i]-reserve[j])<2){
                    lost[i]=-1; reserve[j]=-1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}