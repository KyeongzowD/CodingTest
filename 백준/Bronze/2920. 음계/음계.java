import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());

    int[] arr=new int[8];
    for(int i=0;i<8;i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }
    String s="ascending";

    if(arr[0]==1){
      for(int i=1;i<8;i++){
        if(arr[i]!=i+1){
          s="mixed";
          break;
        }
      }
    }else{
      s="descending";
      for(int i=0;i<8;i++){
        if(arr[i]!=8-i){
          s="mixed";
          break;
        }
      }
    }

    bw.write(s);
    bw.flush();
    bw.close();
    br.close();
  }
}