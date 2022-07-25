import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int ans=0;
        int i;
        for(i=0;(i<N)&&(ans!=N);i++)
        {
            int num=i;
            ans=i;
            while(num>0)
            {
                ans+=num%10;
                num/=10;
            }
        }
        if(i==N){i=0;}
        else{i--;}
        System.out.println(i);
	}
}