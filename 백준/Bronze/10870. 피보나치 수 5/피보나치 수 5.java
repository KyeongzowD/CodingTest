import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int[] arr={0,1};
        if(m<2)
            System.out.println(m);
        else
            System.out.println(Fivo(m-1,arr));
	}
    static int Fivo(int m,int arr[])
    {
        arr[1]+=arr[0];
        arr[0]=arr[1]-arr[0];
        m--;
        if(m==0)
            return arr[1];
        else
            return Fivo(m,arr);
    }
}