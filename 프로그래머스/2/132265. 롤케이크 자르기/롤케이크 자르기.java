import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0; // 공평한 경우의 수
        int len=topping.length;
        int[] first=new int[len];
        int[] last=new int[len];
        
        Set<Integer> setFirst=new HashSet<>();
        Set<Integer> setLast=new HashSet<>();
        
        for(int i=0;i<len;i++){
            setFirst.add(topping[i]);
            setLast.add(topping[len-i-1]);
            
            first[i]=setFirst.size();
            last[len-i-1]=setLast.size();
        }
        
        for(int i=0;i<len-1;i++){
            if(first[i]==last[i+1]) answer++;
        }
        
        return answer;
    }
}