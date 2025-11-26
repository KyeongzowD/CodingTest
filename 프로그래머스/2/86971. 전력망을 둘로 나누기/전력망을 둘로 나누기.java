import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        // wires의 배열 원소 중 하나의 원소를 제외하고 모든 경우의 수 구하기
        
        for(int i=0;i<n-1;i++){
            int[][] wire=new int[n-2][2];
            int k=0;
            for(int j=0;j<n-2;j++,k++){
                if(j==i) k++;
                wire[j][0]=wires[k][0];
                wire[j][1]=wires[k][1]; 
            }
            int oE=oneException(n, wire);
            ans=ans>oE?oE:ans;
        }
        
        return ans;
    }
    
    // 하나의 배열 원소를 제거한 후, 2개의 송전탑 갯수의 차이 리턴
    static int oneException(int n, int[][] wires){
        visited=new boolean[n+1];
        int diff1=0, diff2=0; 
        
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                if(diff1==0) diff1=dfs(i,n, wires,1);
                else diff2=dfs(i,n, wires, 1);
            } 
        }
        return Math.abs(diff1-diff2);
    }
    
    static int dfs(int i, int n, int[][] wires, int depth){
        visited[i]=true;
        for(int k=0;k<n-2;k++){
            if(wires[k][0]==i&&!visited[wires[k][1]])
                depth+=dfs(wires[k][1], n, wires, 1);
            else if(wires[k][1]==i&&!visited[wires[k][0]])
                depth+=dfs(wires[k][0], n, wires, 1);
        }
            
        return depth;
    }
}