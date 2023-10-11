import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N=Integer.parseInt(br.readLine());
    for(int i=0;i<N;i++){
      int ans=1;
      int M=Integer.parseInt(br.readLine());
      
      int c=M/3;//3이 수
      int b=(M-c*3)/2;//2의 수
      int a=M-c*3-b*2;//1의 수
      
      while(c!=0){
        ans+=fact(a+b+c)/(fact(a)*fact(b)*fact(c));
        while(b!=0){
          a+=2; b--;
          ans+=fact(a+b+c)/(fact(a)*fact(b)*fact(c));
        }
        if(c>0){
           c--; a=(M-3*c)%2; b=(M-3*c)/2;
          while(b!=0){
            ans+=fact(a+b+c)/(fact(a)*fact(b)*fact(c));
            a+=2; b--;
          }
        }
      }
      while(b!=0){
        ans+=fact(a+b+c)/(fact(a)*fact(b)*fact(c));
        a+=2; b--;
      }
      
      bw.write(String.valueOf(ans));
      bw.newLine();
    }
    bw.close();
    br.close();
  }
  
  public static int fact(int n){
    if(n<=1){ return 1; }
    else{ return n*fact(n-1); }
  }
}