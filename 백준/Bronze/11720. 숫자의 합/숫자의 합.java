import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        String S_num=sc.next();
        int ans=0;//각 자릿수의 숫자 합을 입력받는 변수
        for(int i=0;i<N;i++)
        {
            ans+=Integer.valueOf(S_num.charAt(i))-48;
            //아스키코드 값이출력
        }
        System.out.print(ans);
    }
}