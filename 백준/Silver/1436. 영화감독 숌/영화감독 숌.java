import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N=Integer.parseInt(br.readLine());

    int[] arr = new int[N];

    int v=1;
    for(int i=0; i<N;v++){
      if(Integer.toString(v).contains("666")){
        arr[i]=v;
        i++;
      }
    }
    
    bw.write(String.valueOf(arr[N-1]));
    bw.flush();
    bw.close();
    br.close();
  }
}