import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static long[][] glass;
    static int answer=0; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        glass=new long[N+2][M+2]; 

        st=new StringTokenizer(br.readLine());//출발할 수 있는 노드에 값1을 넣음

        for(int j=1;j<=M;j++){
            if(st.nextToken().equals("1"))
                glass[1][j]=1;
        }

        for(int i = 2; i <= N; i++) {//도착한 노드의 시점에서 출발 가능한 노드의 합을 도착한 노드에 넣음
            st = new StringTokenizer(br.readLine());

            for(int j = 1;j <= M; j++) {
                //값이 1인 노드가 도착 가능한 노드이기 때문에 0인 노드는 취급하지 않음
                if(st.nextToken().equals("1")){
                    //프로덕트 규칙 적용
                    glass[i][j] += (glass[i - 1][j] + glass[i - 1][j - 1] + glass[i - 1][j + 1]) % 1000000007;
                }
            }
        }

        for(int j=1;j<=M;j++){//
            answer += glass[N][j] % 1000000007;
            answer %= 1000000007;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}