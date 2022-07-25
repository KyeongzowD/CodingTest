import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
       Scanner sc= new Scanner(System.in);
       int[] arr=new int[9];
       for(int i=0;i<9;i++)
       {
            arr[i]=sc.nextInt();
       }
       int max=arr[0];
       int count=1;
       for(int i=1;i<9;i++)
       {
           if(max<arr[i])
               max=arr[i];
       }
        for(int i=0;i<9;i++)
        {
            if(max==arr[i])
                break;
            count++;
        }
       System.out.println(max+"\n"+count);
    }
}