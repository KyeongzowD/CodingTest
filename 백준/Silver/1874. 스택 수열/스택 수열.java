import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb=new StringBuilder();
    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());
    int[] arr=new int[N];
    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(br.readLine());
    }

    Stack<Integer> sk=new Stack<>();

    int idx=1;//스택에 넣을 1~8가지의 값
    int cnt=0;//다음 값이 arr[0]의 값보다 클 경우 입력시켜줌
    for(int i=0;i<=N;i++){
      
      if(!sk.isEmpty()&&sk.peek()==arr[i-1]){//스택의 peek값이 구하려는 수와 같을 경우
        sk.pop();
        sb.append("-\n");
      }

      if(i==N){continue;}
      for(int j=arr[i]-cnt;j>0;j--){//스택에 넣어뒀던 값보다 큰 값이 들어왔을 경우
        cnt=arr[i];
        sk.add(idx);
        idx++;
        sb.append("+\n");
      }
    }

    if(sk.isEmpty()){
      System.out.print(sb);
    }else{
      System.out.print("NO");
    }
  }
}