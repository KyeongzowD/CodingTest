import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int ans=N;
        for(int k=0;k<N;k++)
        {
            String str=sc.next();
            int o=str.length();//문자열의 길이 o
            char strarr[]=new char[o];
            for(int i=0;i<str.length()-1;i++)//연속된 앞문자를 0으로 변환//1
            {
                if(str.charAt(i)==str.charAt(i+1))//
                {
                    strarr[i]='0';
                }
                else
                {
                    strarr[i]=str.charAt(i); 
                }
            }strarr[str.length()-1]=str.charAt(str.length()-1);
            char[] arr=new char[o];//0을 제외한 문자열의 집합
            int j=0;
            for(int i=0; i<o;i++)//문자열의 길이만큼 반복
            {
                if(strarr[i]!='0')//0이 아닌 값을 배열에 입력
                {
                    arr[j]=strarr[i];
                    j++;
                } 
            }
            for(int i=0,p=ans;i<j-1;i++)
            {
                for(int m=i+1;m<j;m++)
                {
                    if(arr[i]==arr[m])
                    {
                        ans--;
                        break;
                    }
                }
                if(p!=ans)
                	break;
            }
        }
        System.out.print(ans);
	}
}