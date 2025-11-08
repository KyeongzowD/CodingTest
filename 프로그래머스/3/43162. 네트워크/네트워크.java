import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0; // 네트워크의 수
        visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visit(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void visit(int i, int n, int[][] computers){
        visited[i]=true;
        for(int j=0;j<n;j++){
            if(!visited[j]&&computers[i][j]==1) visit(j, n, computers);
        }
    }
}