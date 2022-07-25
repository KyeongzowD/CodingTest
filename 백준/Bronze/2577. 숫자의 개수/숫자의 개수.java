import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner stdin= new Scanner(System.in);
        int a=stdin.nextInt();
        int b=stdin.nextInt();
        int c=stdin.nextInt();
        int[] arr={0,0,0,0,0,0,0,0,0,0};
        a=a*b*c;
        for(;;)
        {
            arr[a%10]++;
            a/=10;
            if(a<10)
            {
                arr[a]++;
                break;
            }
        }
        
        for(int i=0;i<10;i++)
        {
            System.out.println(arr[i]);
        }
    }
}