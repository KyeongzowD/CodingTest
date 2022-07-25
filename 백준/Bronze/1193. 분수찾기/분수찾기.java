import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int A=sc.nextInt();
        int x=1,y=1;
        for(int i=1;i!=A;)
        {
            y++;i++;
            if(i==A)
                break;
            do
            {
                x++;y--;
                i++;
            }while(y!=1&&i!=A);
            if(i==A)
                break;
            x++;i++;
            if(i==A)
                break;
            do
            {
                x--;y++;
                i++;
            }while(x!=1&&i!=A);
            if(i==A)
                break;
        }
        System.out.print(x+"/"+y);
    }
}