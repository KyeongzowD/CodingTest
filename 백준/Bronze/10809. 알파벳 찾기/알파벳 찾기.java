import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String S=sc.nextLine();
        int[] num={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        
        for(int i=0;i<S.length();i++)
        {
            if(num[((int)S.charAt(i))-97]==-1)
                num[((int)S.charAt(i))-97]=i;
        }
        for(int i=0;i<26;i++)
        {
            System.out.print(num[i]);
            System.out.print(' ');
        }
    }
}