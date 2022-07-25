import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        int[] arr=new int[T];
        for(int i=0;i<T;i++)
        {
            int H=sc.nextInt();
            int W=sc.nextInt();
            int N=sc.nextInt();
            int x; int y;
            if(N%H==0) {
            	x=N/H;
            	y=H;
            }
            else {
            	x=N/H+1;
            	y=N-H*(x-1);
            }
            arr[i]=y*100+x;
        }
        for(int i=0;i<T;i++)
        {
            System.out.println(arr[i]);
        }

	}

}