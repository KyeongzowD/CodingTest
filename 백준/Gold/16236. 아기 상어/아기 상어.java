import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] fish;
    static int[] dirY= {-1,0,0,1};
    static int[] dirX= {0,-1,1,0};
    static int size;//먹은 물고기 수, 아기 상어 크기
    static int y,x;//아기 상어 위치 y,x
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        N=Integer.parseInt(br.readLine());
        fish=new int[N][N];
        int ans=0;
        size=2;
        
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                fish[i][j]=Integer.parseInt(st.nextToken());
                if(fish[i][j]==9) {y=i;x=j;fish[i][j]=0;}
            }
        }
        
        //초기 아기상어의 크기 : 2
        int count=1;
        while(count!=0) {
            for(int i=0;i<size&&count!=0;i++){//아기상어의 사이즈만큼 반복
                count=BFS();
                ans+=count;
            }
            size++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    
    static public int BFS() {//먹이까지의 최단 거리 반환
        int[][] visited=new int[N][N];
        Queue<int[]> que=new LinkedList<int[]>();
        List<int[]> feed=new LinkedList<int[]>();//먹이 리스트
        que.add(new int[]{y,x});
        int min=Integer.MAX_VALUE;
        
        while(!que.isEmpty()) {
            int p[]=que.poll();
            for(int k=0;k<4;k++) {
                int dy=p[0]+dirY[k];
                int dx=p[1]+dirX[k];
                if(dy==y&&dx==x) continue;

                if(dy>=0&&dy<N&&dx>=0&&dx<N&&visited[dy][dx]==0) {
                    //자신보다 큰 물고기는 지나갈 수 없음
                    if(fish[dy][dx]>size) continue;

                    if(fish[dy][dx]<size&&fish[dy][dx]!=0) {
                        
                        if(min>visited[p[0]][p[1]]+1){
                            feed.clear();
                            feed.add(new int[]{dy,dx});
                            min=visited[p[0]][p[1]]+1;
                        }else if(min==(visited[p[0]][p[1]]+1)){
                            feed.add(new int[]{dy,dx});
                        }
                        
                    }
                    //같거나 0일 경우-> 지나가기만 가능
                    visited[dy][dx]=visited[p[0]][p[1]]+1;
                    
                    que.add(new int[]{dy,dx});
                }
            }
            //거리가 같은 지점 모두 탐색
        }

        if(feed.isEmpty()) return 0;//먹이를 발견하지 못할 경우

        //발견했을 경우 -> i 정렬,j 정렬 후 
        //y,x 좌표 다시 등록 , fish 배열에 0처리
        // 가장 위쪽, 가장 왼쪽에 있는 물고기 선택
        feed.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        y=feed.get(0)[0];
        x=feed.get(0)[1];
        fish[y][x]=0;

        return min;
    }
}