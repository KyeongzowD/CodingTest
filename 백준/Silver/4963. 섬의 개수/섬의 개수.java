import java.util.*;
import java.io.*;

class Island{
  static boolean map[][];
  static int W,H;//w는 너비 h는 높이 
  static int dirY[]={-1,-1,-1,0,0,1,1,1};
  static int dirX[]={-1,0,1,-1,1,-1,0,1};
  static int ans;//ans는 섬의 개수
  
  Island(int h,int w) {
    W=w; H=h;
    map=new boolean[H+1][W+1];
  }

  public void line(StringTokenizer s,int i) {
    for(int j=0;j<W;j++){
      if(s.nextToken().equals("1"))
        map[i][j]=true;
    }
  }

  public int answer() { return ans; }
  
  public void reset() { ans=0; }

  public void loop(){
    for(int i=0;i<H;i++){
      for(int j=0;j<W;j++){
        if(map[i][j]){
          DFS(i,j);
          ans++;
        }
      }
    }
  }
  
  public void DFS(int y,int x){
    map[y][x]=false;
    for(int i=0;i<8;i++){
      int newX=x+dirX[i];
      int newY=y+dirY[i];
      if(newX>=0&&newY>=0&&newX<=W&&newY<=H&&map[newY][newX]){
        DFS(newY,newX);
      }
    }
  }
}

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true){
      StringTokenizer st=new StringTokenizer(br.readLine());
      int w=Integer.parseInt(st.nextToken());//너비j
      int h=Integer.parseInt(st.nextToken());//높이i
      
      if(w==0&&h==0)
        break;

      Island is=new Island(h,w);
      
      for(int i=0;i<h;i++){
        st=new StringTokenizer(br.readLine());
        is.line(st,i);
      }
      is.loop();
      
      bw.write(String.valueOf(is.answer()));
      is.reset();
      bw.newLine();
    }
    br.close();
    bw.close();
  }
}