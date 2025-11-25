class Solution {
    static int max=0, len;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        len=dungeons.length;
        visited=new boolean[len];
        
        for(int i=0;i<len;i++){
            visited[i]=true;
            dfs(k, dungeons, 0, i);
            visited[i]=false;
        }
        return max;
    }
    
    static void dfs(int k, int[][] dungeons, int cnt, int m){
        if(dungeons[m][0]>k) return;
        k-=dungeons[m][1];
        
        cnt++;
        max=cnt>max?cnt:max;
        
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(k, dungeons, cnt, i);
                visited[i]=false;
            }
        }
    }
}