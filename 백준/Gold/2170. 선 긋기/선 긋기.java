import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    int ans=0;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    int N=Integer.parseInt(br.readLine());

    int[][] line=new int[N][2];
    //line[][0]: start / line[][1]: end

    for(int i=0;i<N;i++){
      String s=br.readLine();
      String[] arr=s.split(" ");
      
      line[i][0]=Integer.parseInt(arr[0]);
      line[i][1]=Integer.parseInt(arr[1]);
    }

    Arrays.sort(line, new Comparator<int[]>() { //x좌표 오름차순 정렬. x좌표 같으면 y좌표 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])  return o1[1] - o2[1];
                else  return o1[0] - o2[0];
            }
        });  

    int x=line[0][0];
    int y=line[0][1];
    
    for(int i=0;i<N-1;i++){
      if(y>=line[i+1][0]){// [1,4] [2,5]일 경우 [1,5]로 만들기 위해서
        if(y<line[i+1][1])
          y=line[i+1][1];
        continue;
      }
      
      ans+=y-x;

      x=line[i+1][0];
      y=line[i+1][1];
    }

    ans+=y-x;

    br.close();
    bw.write(""+ans);
    bw.flush();
    bw.close();
  }
}