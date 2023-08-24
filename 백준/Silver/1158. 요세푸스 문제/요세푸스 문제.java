import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder("<");

    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());
    int K=Integer.parseInt(st.nextToken());

    boolean[] arr=new boolean[N];//true는 탈락한 사람

    int j=1;
    int cnt=0;
    for(int i=0;;i++){
      if(arr[i%N]){
        continue;
      }
      if(j==K){
        arr[i%N]=true;
        if(cnt==N-1){
          sb.append(i%N+1);
          break;
        }else{
         sb.append(i%N+1+", "); 
        }
        j=0;cnt++;
      }
      j++;
    }

    sb.append(">");
    System.out.println(sb);
    br.close();
  }
}