import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Long> que=new PriorityQueue<>();
        
        for(long i:scoville){
            que.add(i);
        }
        
        while(que.peek()<K){
            if(que.size()<2) return -1;
            answer++;
            long a=que.poll();
            long b=que.poll();
            
            que.add(a+b*2);
        }
        return answer;
    }
}