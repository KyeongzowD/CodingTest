import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		String[] S=new String[T];
		String[] P=new String[T];
		
		
		for(int i=0;i<T;i++)
		{
            P[i]="";
			int R=sc.nextInt();
			S[i]=sc.next();
			for(int j=0;j<S[i].length();j++)
			{
				for(int k=0;k<R;k++)
				{
					sb.append(S[i].charAt(j));//P의 문자열에 문자 추가하는 함수 append
				}
			}
			P[i]+=sb;
			sb.delete(0, sb.length());
		}
		for(int i=0;i<T;i++)
        {
            System.out.println(P[i]);
        }
	}
}