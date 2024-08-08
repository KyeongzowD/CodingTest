import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());// 트럭의 수
    int W = Integer.parseInt(st.nextToken());// 다리의 길이
    int L = Integer.parseInt(st.nextToken());// 다리의 최대 하중

    Queue<Integer> truck = new LinkedList<Integer>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      truck.add(Integer.parseInt(st.nextToken()));
    }

    Queue<Integer> bridge = new LinkedList<Integer>();
    for(int i=0;i<W;i++){
      bridge.add(0);
    }

    int bridgeWeight=0;
    int count=0;

    while(!bridge.isEmpty()){//다리 위에 트럭이 존재할 경우 없어질 때까지 반복
      bridgeWeight-=bridge.poll();
      
      if(!truck.isEmpty()){//다리 위에 올라가지 않은 트럭이 있을 경우 true
        if(bridgeWeight+truck.peek()<=L){//다리 위에 올라갈 수 있으면 true
          bridgeWeight+=truck.peek();
          bridge.add(truck.poll());
        }else{
          bridge.add(0);   
        }  
      }
      
      count++;
    }

    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }
}