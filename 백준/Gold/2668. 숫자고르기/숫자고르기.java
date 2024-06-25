import java.util.*;
import java.io.*;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer> list=new ArrayList<Integer>();
  static int[] num;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());

    visited=new boolean[N+1];
    num=new int[N+1];

    for(int i=1;i<=N;i++){
      num[i]=Integer.parseInt(br.readLine());
    }

    for(int i=1;i<=N;i++){
      visited[i]=true;
      DFS(i,i);
      visited[i]=false;
    }

    Collections.sort(list);
    
    bw.write(String.valueOf(list.size()));
    bw.newLine();
    for(int i=0;i<list.size();i++){
      bw.write(String.valueOf(list.get(i)));
      bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
  }

  //DFS
  static void DFS(int idx,int target){//시작 노드
    if(!visited[num[idx]]){
      visited[num[idx]]=true;
      DFS(num[idx],target);
      visited[num[idx]]=false;
    }
    if(num[idx]==target)
      list.add(target);
  }
}