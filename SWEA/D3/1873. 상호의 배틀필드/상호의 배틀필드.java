import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();//출력에서 사용
		StringTokenizer st;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			st=new StringTokenizer(br.readLine());
			int H=Integer.parseInt(st.nextToken());
			int W=Integer.parseInt(st.nextToken());
			
			int y=0,x=0;//전차의 위치 
			
			char[][] arr=new char[H][W];//H(높이) j, y
			
			for(int i=0;i<H;i++) {
				String s=br.readLine();
				arr[i]=s.toCharArray();
				if(s.contains(">")||s.contains("<")||s.contains("^")||s.contains("v")) {
					y=i;
					for(int j=0;j<s.length();j++) {
						if(arr[i][j]=='>'||arr[i][j]=='<'||arr[i][j]=='^'||arr[i][j]=='v')
							x=j;
					}
				}
			}			
			
			char watch=arr[y][x];//전차 모양 

			int N=Integer.parseInt(br.readLine());
			String Nstring=br.readLine();
			char[] Narr=Nstring.toCharArray();
			
			for(int i=0;i<N;i++){
				switch(Narr[i]) {
				case 'S':
					if(watch=='^') {
						for(int k=y-1;k>=0;k--) {
							if(arr[k][x]=='*') {
								arr[k][x]='.';
								break;
							}else if(arr[k][x]=='#') {
								break;
							}
						}
						
					}else if(watch=='v') {
						for(int k=y+1;k<H;k++) {
							if(arr[k][x]=='*') {
								arr[k][x]='.';
								break;
							}else if(arr[k][x]=='#') {
								break;
							}
						}
						
					}else if(watch=='<') {
						for(int k=x-1;k>=0;k--) {
							if(arr[y][k]=='*') {
								arr[y][k]='.';
								break;
							}else if(arr[y][k]=='#') {
								break;
							}
						}
						
					}else if(watch=='>') {
						for(int k=x+1;k<W;k++) {
							if(arr[y][k]=='*') {
								arr[y][k]='.';
								break;
							}else if(arr[y][k]=='#') {
								break;
							}
						}
					}
					break;//shoot

				case 'U':
					watch='^';
					if(y>0&&arr[y-1][x]=='.') {
						arr[y][x]='.';
						y--;
					}
					arr[y][x]=watch;
					break;
					
				case 'D':
					watch='v';
					if(y<H-1&&arr[y+1][x]=='.') {
						arr[y][x]='.';
						y++;
					}
					arr[y][x]=watch;
					break;
					
				case 'R':
					watch='>';
					if(x<W-1&&arr[y][x+1]=='.') {
						arr[y][x]='.';
						x++;
					}
					arr[y][x]=watch;
					break;
					
				case 'L':
					watch='<';
					if(x>0&&arr[y][x-1]=='.') {
						arr[y][x]='.';
						x--;
					}
					arr[y][x]=watch;
					break;
				default:
					break;
				}				
			}
			
			for(int i=0;i<H;i++) {
				String charArrToString=new String(arr[i]);
				sb.append(charArrToString).append("\n");
			}			
		}
		System.out.println(sb.toString());
	}
}