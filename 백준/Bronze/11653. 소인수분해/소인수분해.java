import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int count=0;
        int[] Array=new int[N+1];//1000까지 소수
        for(int i=2;i<N+1;i++)//2부터 N까지 모든 수에 1
        {
            Array[i]=1;
        }
        Array[0]=0;
        Array[1]=0;
        for(int i=2;(i!=1)&&(i<Math.sqrt(N+1));i++)//2의 배수부터 100의 제곱근까지의 배수 값을 0으로 초기화
        {
            for(int j=2;i*j<N+1;j++)
            {
                Array[i*j]=0;//소수가 아닌 수는 0
            }
        }
        for(int i=2;N!=1;i++)
        {
            while((N%i==0)&&(Array[i]==1))
            {
                N/=i;
                System.out.println(i);
            }
        }
    }
}