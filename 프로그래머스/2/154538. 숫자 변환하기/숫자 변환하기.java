import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if (x==y) return 0;
        int[] dist=new int[y+1]; // 이동 cnt가 적힌 배열
        Arrays.fill(dist, -1);
        
        Queue<Integer> que=new ArrayDeque<>();
        dist[x]=0;
        que.offer(x);
        
        
        while(!que.isEmpty()){
            int cur=que.poll();
            
            int[] nexts = {cur+n, cur*2, cur*3};
            for(int nc : nexts){
                if(nc>y) continue;
                if(dist[nc]!= -1) continue;
                
                dist[nc]=dist[cur]+1;
                if(nc==y) return dist[nc];
                que.offer(nc);
            }
        }
        
        return -1;
    }
}