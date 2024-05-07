import java.util.*;
import java.io.*;
public class Main
{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N=Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(deque.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(String.valueOf(deque.pop())).append("\n");
                    break;

                case "size":
                    sb.append(String.valueOf(deque.size())).append("\n");
                    break;

                case "empty":
                    if(deque.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;

                case "front":
                    if(deque.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(String.valueOf(deque.peekFirst())).append("\n");
                    break;

                case "back":
                    if(deque.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(String.valueOf(deque.peekLast())).append("\n");
                    break;

            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
  }
}