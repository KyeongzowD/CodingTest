import java.util.*;

class Solution {
    static boolean[][] map=new boolean[102][102];
    static int[][] dist=new int[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 가능한 경로가 2가지일 경우, 자신과 동일한 사각형의 경로를 따라가지 않고 다른 사각형의 경로로 변경됨
        
        int len=rectangle.length;
        // 테두리를 모두 true 처리
        for(int i=0;i<len;i++){
            outRectangle(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }// 다른 사각형 안에 있는 테두리를 false 처리
        for(int i=0;i<len;i++){
            inRectangle(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
    }
    
    static public int bfs(int x1,int y1, int x2, int y2){
        int[] dirY={-1,0,1,0};
        int[] dirX={0,1,0,-1};
        
        Queue<int[]> que=new ArrayDeque<>();
        que.offer(new int[]{y1, x1});
        dist[y1][x1]=0;
        
        while(!que.isEmpty()){
            int[] node=que.poll();
            if(node[1]==x2&&node[0]==y2) return dist[y2][x2]; //도착지일 경우 반환
            
            for(int k=0;k<4;k++){
                int i=node[0]+dirY[k], j=node[1]+dirX[k];
                
                if(i>=0&&j>=0&&map[i][j]){
                    que.offer(new int[]{i,j});
                    dist[i][j]=dist[node[0]][node[1]]+1;
                }
            }
            map[node[0]][node[1]]=false; //방문한 노드를 재방문하지 않기 위해
        }        
        return -1;
    }
    
    // 직사각형의 내부는 false, 외부는 true
    static public void inRectangle(int x1,int y1, int x2, int y2){ // 내부 false 처리
        for(int i=x1+1;i<x2;i++){
            for(int j=y1+1;j<y2;j++){
                map[j][i]=false;
            }
        }
    }
    
    static public void outRectangle(int x1,int y1, int x2, int y2){ // 외부 true 처리
        // 직사각형의 가로변 등록
        for(int i=x1;i<=x2;i++){
            map[y1][i]=true; map[y2][i]=true;
        }
        // 직사각형의 세로변 등록
        for(int j=y1;j<=y2;j++){
            map[j][x1]=true; map[j][x2]=true; 
        }
    }
}