import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        int[] num=new int[T];
        int[] Num=new int[T*2];
        for(int i=0;i<T;i++)
        {
            num[i]=sc.nextInt();
        }
        int[] Array=new int[10001];
        for(int i=2;i<10001;i++)//2부터 N까지 모든 수에 1
        {
            Array[i]=1;
        }
        Array[0]=0;
        Array[1]=0;
        for(int i=2;(i!=1)&&(i<10001);i++)
        {
            for(int j=2;i*j<10001;j++)
            {
                Array[i*j]=0;//소수가 아닌 수는 0
            }
        }
        for(int i=0;i<T;i++)
        {
            int j=num[i]/2;
            while((Array[num[i]-j]==0)||(Array[j]==0))
            {
                j++;
            }
            Num[i*2]=num[i]-j;
            Num[i*2+1]=j;
        }
        for(int i=0;i<T;i++)
        {
             System.out.println(Num[i*2]+" "+Num[i*2+1]);   
        }
    }
}