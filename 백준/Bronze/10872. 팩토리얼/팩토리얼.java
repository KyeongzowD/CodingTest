import java.util.Scanner;
public class Main{
    
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        System.out.println(facto(m));
	}
    static int facto(int m)
    {
        int result=m;
        if(m==1)
            return result;
        else if(m==0)
            return 1;
        else
            return m*facto(m-1);
    }
}