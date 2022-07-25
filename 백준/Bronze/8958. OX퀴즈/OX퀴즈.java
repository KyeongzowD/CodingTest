import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int[] score=new int[N];
        for(int i=0;i<N;i++)
        {
            String result=sc.next();
            for(int j=0,k=1;j<result.length();j++)//O이면 1점 K가 score에 합
            {
                if(result.charAt(j)=='O')//문자열에서 특정문자 도출
                {
                	score[i]+=k;
                	k++;
                }
                else
                    k=1;
            }
        }
        for(int i=0;i<N;i++)
        {
            System.out.println(score[i]);
        }     
    }
}