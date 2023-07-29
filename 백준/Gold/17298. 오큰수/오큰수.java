import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    Stack<Integer> st=new Stack<Integer>();//스택에는 인덱스값이 들어감

    int N=Integer.parseInt(br.readLine());

    int arr[]=new int[N];
    StringTokenizer stk=new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(stk.nextToken());
    }

    for(int i=0;i<N;i++){
      while(!st.empty()&&arr[st.peek()]<arr[i]){//스택이 비어있지 않아야하고 st에 있는 인덱스 값의 배열 값보다 현재의 배열값이 더 크면 
        arr[st.pop()]=arr[i];//값이 바뀜
      }
      st.push(i);
    }

    while(!st.isEmpty()){
      arr[st.pop()]=-1;
    }

    for(int i=0;i<N;i++){
      bw.write(arr[i]+" ");
    }
    
    bw.flush();
    br.close();
    bw.close();
	}
}