import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringBuilder sb=new StringBuilder(br.readLine());
    int len=sb.length();
    String[] arr=new String[len];
    
    for(int i=0;i<len;i++){
      arr[i]=sb.substring(i);
    }

    Arrays.sort(arr);

    for(int i=0;i<len;i++){
      bw.write(arr[i]);
      bw.newLine();
      bw.flush();
    }
    
    bw.close();
    br.close();
  }
}