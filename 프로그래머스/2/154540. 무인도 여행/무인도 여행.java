import java.util.*;
class Solution {
    static int[] dirY={-1,0,1,0}, dirX={0,-1,0,1};
    static List<Integer> list=new ArrayList<>();
    static boolean[][] visited;
    static String[] maps;
    static int iLen, jLen;
    
    public int[] solution(String[] maps) {
        iLen=maps.length; jLen=maps[0].length();
        
        visited=new boolean[iLen][jLen];
        this.maps=maps;
        
        for(int i=0;i<iLen;i++){
            for(int j=0;j<jLen;j++){
                if(!visited[i][j]&&maps[i].charAt(j)!='X') list.add(dfs(i,j));
            }
        }
        int[] answer;
        if(list.size()!=0){
            Collections.sort(list);
            answer=list.stream().mapToInt(i->i).toArray();
        }else{
            answer=new int[]{-1};
        }
        return answer;
    }
    
    static int dfs(int i, int j){
        int sum=maps[i].charAt(j)-48;
        visited[i][j]=true;
        
        for(int d=0;d<4;d++){
            int y=i+dirY[d];
            int x=j+dirX[d];
            
            if(y>=0&&y<iLen&&x>=0&&x<jLen&&!visited[y][x]&&maps[y].charAt(x)!='X'){
                sum+=dfs(y,x);
            }
        }
        return sum;
    }
}