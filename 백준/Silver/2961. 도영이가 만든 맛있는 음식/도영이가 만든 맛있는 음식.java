import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int answer;

    int N=Integer.parseInt(br.readLine());
    Taste[] arr=new Taste[N];

    for(int i=0;i<N;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      int s=Integer.parseInt(st.nextToken());
      int v=Integer.parseInt(st.nextToken());

      arr[i]=new Taste(s,v);
    }

    answer=(arr[0].S>arr[0].V)?arr[0].S-arr[0].V:arr[0].V-arr[0].S;

    int cnt=(int)Math.pow(2,N);
    for(int i=1;i<cnt;i++){//i는 바이너리로 사용되는 값
      int sour=1;
      int bitt=0;

      String s=Integer.toBinaryString(i);
      while(s.length()<N){
        s="0"+s;
      }

      for(int j=0;j<N;j++){
        if(s.charAt(j)=='1'){
          sour*=arr[j].S;
          bitt+=arr[j].V;
        }
      }

      int cha=sour>bitt?sour-bitt:bitt-sour;

      if(cha<answer)
        answer=cha;
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
    br.close();

    
  }
  static class Taste{//신맛 s, 쓴맛 V
    int S,V;

    Taste(int s,int v){
      S=s; V=v;
    }
  }
}