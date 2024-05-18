import java.util.*;
import java.io.*;

class Solution
{
	
	static int N;
	static int[][] arr;//1부터 N의 제곱의 값까지 들어가있는 배
	static int[][] arr_max;//각 값이 이동할 수 있는 최대거리 
	static int ans=1,max=1;
	static int x,y;//최대값인 배열의 인덱스 
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans=1;max=1;x=0;y=0;
			sb.append("#").append(Integer.toString(test_case)).append(" ");
			N=Integer.parseInt(br.readLine());
			arr=new int[N+2][N+2];
			
			for(int i=1;i<=N;i++) {//이차원 배열에 값 입력 
				st=new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					ans=1;
					dfs(i,j);
					if(max<ans) {
						max=ans;
						x=i;y=j;
					}else if(max==ans) {
						if(arr[i][j]<arr[x][y]) {
							x=i;y=j;
						}
					}
				}
			}
			
			sb.append(Integer.toString(arr[x][y])).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int i,int j) {
		if(arr[i][j]+1==arr[i-1][j]) {
			dfs(i-1,j);
		}else if(arr[i][j]+1==arr[i+1][j]) {
			dfs(i+1,j);
		}else if(arr[i][j]+1==arr[i][j-1]) {
			dfs(i,j-1);
		}else if(arr[i][j]+1==arr[i][j+1]) {
			dfs(i,j+1);
		}else {
			return;
		}
		ans++;
	}
}