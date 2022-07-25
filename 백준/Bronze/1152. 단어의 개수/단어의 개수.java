import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String txt=sc.nextLine();
        int count=1;
        for(int i=1;i<txt.length();i++)
        {
            if(txt.charAt(i)==' ')
                count++;
        }
        if(txt.charAt(txt.length()-1)==' ')
            count--;
        System.out.print(count);
    }
}