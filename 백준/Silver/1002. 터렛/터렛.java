import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());

    int T=Integer.parseInt(st.nextToken());

    for(int i=0;i<T;i++){  
      int ans=0;
      st=new StringTokenizer(br.readLine());
      int x1=Integer.parseInt(st.nextToken());
      int y1=Integer.parseInt(st.nextToken());
      int r1=Integer.parseInt(st.nextToken());
      int x2=Integer.parseInt(st.nextToken());
      int y2=Integer.parseInt(st.nextToken());
      int r2=Integer.parseInt(st.nextToken());

      double d=Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));

      double sum=r1+r2;
      double sub=Math.abs(r1-r2);//절대값

      if(d==0&&r1==r2){
        ans=-1;
      }else if(d<sub){
        ans=0;
      }else if(d>sum){
        ans=0;
      }else if(d==sum||d==sub){
        ans=1;
      }else{
        ans=2;
      }

      bw.write(String.valueOf(ans));
      bw.newLine();
    }
    
    bw.close();
    br.close();

  }
}