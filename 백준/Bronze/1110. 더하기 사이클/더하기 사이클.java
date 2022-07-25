import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
       Scanner stdin= new Scanner(System.in);
       int N=stdin.nextInt();
       int val=N;
       int count=0;
       do
       {
           N=(N%10)*10+((N%10+N/10)%10);
           count++;
       }while(N!=val);
       System.out.print(count);
    }
}