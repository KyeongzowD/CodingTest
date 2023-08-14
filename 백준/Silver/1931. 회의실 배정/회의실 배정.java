import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());

    int[][] arr=new int[N][2];

    for(int i=0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      arr[i][0]=Integer.parseInt(st.nextToken());
      arr[i][1]=Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, (o1, o2) -> {//이차원 배열 정렬
            if(o1[1] == o2[1]) { 
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

    int ans=0;
    int y=0;
    for(int i=0;i<N;i++){
      if(y<=arr[i][0]){
        y=arr[i][1];
        ans++;
      }
    }
    
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
    br.close();
    
  }
}