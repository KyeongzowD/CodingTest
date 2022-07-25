import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner stdin= new Scanner(System.in);
        int A=stdin.nextInt();
        int B=stdin.nextInt();
        int C=stdin.nextInt();
        if(C<=B)
        {
            System.out.print("-1");
        }
        else
        {
            A=A/(C-B);
            A++;
            System.out.print(A);
        }
        
    }
}