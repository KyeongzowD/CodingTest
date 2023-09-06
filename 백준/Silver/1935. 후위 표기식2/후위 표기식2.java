import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N=Integer.parseInt(br.readLine());
    StringBuilder sb=new StringBuilder(br.readLine());

    int len=(sb.length()-1)/2;
    double[] arr=new double[N+len];
    int i=0;
    for(;i<N;i++){
      arr[i]=Integer.parseInt(br.readLine());
    }

    while(len-->0){//계산식만큼 반복
      int j=2;//후위연산이기 때문에 인덱스 2부터 시작
      while(true){
          if(sb.charAt(j)=='+'){
            arr[i]=arr[sb.charAt(j-2)-65]+arr[sb.charAt(j-1)-65];
            sb.delete(j-2,j+1); sb.insert(j-2,Character.toString((char)(i+65)));i++;
            break;
          }
          else if(sb.charAt(j)=='-'){
            arr[i]=arr[sb.charAt(j-2)-65]-arr[sb.charAt(j-1)-65];
            sb.delete(j-2,j+1); sb.insert(j-2,Character.toString((char)(i+65)));i++;
            break;
          }
          else if(sb.charAt(j)=='*'){
            arr[i]=arr[sb.charAt(j-2)-65]*arr[sb.charAt(j-1)-65];
            sb.delete(j-2,j+1); sb.insert(j-2,Character.toString((char)(i+65)));i++;
            break;
          }
          else if(sb.charAt(j)=='/'){
            arr[i]=arr[sb.charAt(j-2)-65]/arr[sb.charAt(j-1)-65];
            sb.delete(j-2,j+1); sb.insert(j-2,Character.toString((char)(i+65)));i++;
            break;
          }//숫자일 경우는 제외함
        j++;
      }
    }

    System.out.printf("%.2f",arr[arr.length-1]);
    br.close();
  }
}