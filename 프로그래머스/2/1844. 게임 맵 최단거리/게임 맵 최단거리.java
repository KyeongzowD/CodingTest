import java.util.*;

class Solution {
    static int[][] len;
    static int[] dirY={-1,0,1,0};
    static int[] dirX={0,-1,0,1};
    
    public int solution(int[][] maps) {
        int iLen=maps.length;
        int jLen=maps[0].length;
        len=new int[iLen][jLen];
        len[0][0]=1;
        
        bfs(maps, iLen, jLen);
        
        int ans=len[iLen-1][jLen-1];
        if(ans==0) return -1;
        else return ans;
    }
    
    static void bfs(int[][] maps, int iLen, int jLen){
        int ans=0;
        Queue<int[]> que=new ArrayDeque<>();
        que.offer(new int[]{0,0});
        
        while(!que.isEmpty()){
            int[] arr=que.poll();
            
            for(int k=0;k<4;k++){
                int i=arr[0]+dirY[k];
                int j=arr[1]+dirX[k];
                
                if(i>=0&&j>=0&&i<iLen&&j<jLen&&maps[i][j]==1&&len[i][j]==0){
                    len[i][j]=len[arr[0]][arr[1]]+1;
                    que.offer(new int[]{i,j});
                }
            }
        }
         
    }
}