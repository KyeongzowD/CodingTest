import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int b_weight = 0;
        Queue<Integer> que = new LinkedList<>();
        
        int i=0;
        for(;i<bridge_length;i++)
            que.offer(0);
        
        i=0;
        final int len=truck_weights.length;
        
        while(i!=len){
                b_weight-=que.poll();
            if(b_weight+truck_weights[i]<=weight){//다음 트럭의 무게를 합쳤을 때 가능한 경우
                b_weight+=truck_weights[i];
                que.offer(truck_weights[i]);
                i++;
            }else{//불가능할 경우
                que.offer(0);
            }
            answer++;
        }
        
        while(!que.isEmpty()){
            answer++;
            que.poll();
        }
        
        return answer;
    }
}