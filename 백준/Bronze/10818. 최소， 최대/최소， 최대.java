import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
       Scanner sc= new Scanner(System.in);
       int N=sc.nextInt();
       int max,min;
       int[] arr=new int[N];
       for(int i=0;i<N;i++)
       {
            arr[i]=sc.nextInt();
       }
       min=arr[0];
       max=arr[0];
       for(int i=1;i<N;i++)
       {
           if(min>arr[i])
               min=arr[i];
           if(max<arr[i])
               max=arr[i];
       }
       System.out.print(min+" "+max);
    }
}