import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        int ans=0;
        int[] num=new int[3];
        if(x<100)
            ans=x;
        else
        {
            ans+=99;
            for(int i=100;i<=x;i++)
            {
            	int sibal=i;
            	for(int j=0;j<3;j++)
            	{
            		num[j]=sibal%10;
            		sibal/=10;
            	}
                if((num[2]-num[1])==(num[1]-num[0]))
                ans++;
            }
        }
        if(x==1000)
            ans--;

        System.out.print(ans);
    }
}