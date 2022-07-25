import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];//소수인지 판별되는 입력받는 수 
        int count=0;//입력받는 수 중 소수를 count
        for(int i=0;i<N;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] Array=new int[1001];//100까지 소수
        for(int i=2;i<1001;i++)//2부터 100까지 모든 수에 1
        {
            Array[i]=1;
        }
        Array[0]=0;
        Array[1]=0;
        for(int i=2;(i!=1)&&(i<Math.sqrt(1001));i++)//2의 배수부터 100의 제곱근까지의 배수 값을 0으로 초기화
        {
            for(int j=2;i*j<1001;j++)
            {
                Array[i*j]=0;//소수가 아닌 수는 0
            }
        }
        for(int i=0;i<N;i++)
        {
            if(Array[arr[i]]==1)
                count++;
        }
        System.out.print(count);
    }
}