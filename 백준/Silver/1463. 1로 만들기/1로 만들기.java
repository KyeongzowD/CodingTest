import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args)throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N=Integer.parseInt(br.readLine());
    int[] arr=new int[N+4];
    arr[1]=0; arr[2]=1; arr[3]=1; arr[4]=2;

    for(int i=5;i<N+1;i++){
      if(i%3!=0&&i%2!=0){//2,3으로 나누어지지 않을 경우//1
        arr[i]=arr[i-1]+1;
      }else{
        if(i%3==0&&i%2==0){
          if(arr[i/3]<=arr[i/2]&&arr[i/3]<=arr[i-1]){//2
            arr[i]=arr[i/3]+1;
          }else if(arr[i/2]<=arr[i-1]&&arr[i/2]<=arr[i/3]){//3
            arr[i]=arr[i/2]+1;
          }else{//4
            arr[i]=arr[i-1]+1;
          }
        }else if(i%3==0){
          if(arr[i/3]<=arr[i-1]){
            arr[i]=arr[i/3]+1;
          }else{
            arr[i]=arr[i-1]+1;
          }
        }else if(i%2==0){
          if(arr[i/2]<=arr[i-1]){
            arr[i]=arr[i/2]+1;
          }else{
            arr[i]=arr[i-1]+1;
          }
        }
      }
    }
    
    bw.write(String.valueOf(arr[N]));
    bw.flush();
    bw.close();
    br.close();
  }
}