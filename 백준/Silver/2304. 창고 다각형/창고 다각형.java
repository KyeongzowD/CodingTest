import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int ans=0;
    
    int N=Integer.parseInt(br.readLine());
    int[][] arr=new int[N][2];//인덱스값, 높이

    int max=0;
    
    for(int i=0;i<N;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      arr[i][0]=Integer.parseInt(st.nextToken());
      arr[i][1]=Integer.parseInt(st.nextToken());

      if(arr[i][1]>max){
        max=arr[i][1];
      }
    }

    Arrays.sort(arr,Comparator.comparingInt(o1->o1[0]));
    
    int start_i=arr[0][0];//최대 h 높이를 가진 첫번째 인덱스값
    int end_i=arr[N-1][0];//최대 h 높이를 가진 마지막 인덱스값
    int h=arr[0][1];//현재 높이
    int j=arr[0][0];
    
    for(int i=0;i<N;i++){//앞에서 뒤로
      if(h<arr[i][1]&&i!=0){//더 높은 값으로 바뀌었을 때
        ans+=(arr[i][0]-j)*h;
        h=arr[i][1];
        j=arr[i][0];
      }
      if(arr[i][1]==max){
        start_i=arr[i][0];
        break;
      }
    }

    h=arr[N-1][1];//현재 높이
    j=arr[N-1][0];
    for(int i=N-1;i>0;i--){//뒤에서 앞으로
      if(h<arr[i][1]&&i!=0){//더 높은 값으로 바뀌었을 때
        ans+=(j-arr[i][0])*h;
        h=arr[i][1];
        j=arr[i][0];
      }
      if(arr[i][1]==max){
        end_i=arr[i][0];
        break;
      }
    }
    ans+=max*(end_i-start_i+1);
    
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
    br.close();
  }
}