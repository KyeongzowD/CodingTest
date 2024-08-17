import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder("");

    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }
    Arrays.sort(arr);

    for(int i=1;i<N;i++){
      if(arr[i-1].equals(arr[i]))
        arr[i-1]="";
    }
    
    Arrays.sort(arr, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

    for (int i = 0; i < N; i++) {
      if(!arr[i].equals(""))
        sb.append(arr[i]).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}