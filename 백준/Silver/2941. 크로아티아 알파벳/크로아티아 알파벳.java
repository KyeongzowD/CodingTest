import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int count=str.length();
        str=str.replace("dz=","2");
        str=str.replace("c=","1");
        str=str.replace("c-","1");
        str=str.replace("d-","1");
        str=str.replace("lj","1");
        str=str.replace("nj","1");
        str=str.replace("s=","1");
        str=str.replace("z=","1");
        for(int i=0;i<str.length();i++)
        {
            if((int)str.charAt(i)==49)
                count-=1;
            else if((int)str.charAt(i)==50)
                count-=2;
        }
        System.out.print(count);
    }
}