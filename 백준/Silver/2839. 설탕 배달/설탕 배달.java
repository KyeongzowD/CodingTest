import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int x=0,y=0;
        switch(N%5)
        {
            case 0:
                x=N/5;
                break;
            case 1:
                x=N/5-1;
                y=2;
                break;
            case 2:
                x=N/5-2;
                y=4;
                break;
            case 3:
                x=N/5;
                y=1;
                break;
            case 4:
                x=N/5-1;
                y=3;
                break;
        }
        if(x<0)
            System.out.print(-1);
        else
            System.out.print(x+y);        
    }
}