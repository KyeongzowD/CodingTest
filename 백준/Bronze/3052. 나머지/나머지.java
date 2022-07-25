import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner stdin= new Scanner(System.in);
        int[] arr=new int[10];
        int count=0;
        for(int i=0;i<10;i++)
        {
             arr[i]=stdin.nextInt();
        }
        for(int i=0;i<10;i++)
        {
             arr[i]=arr[i]%42;
        }
        for(int i=0;i<9;i++)
        {
              for(int j=i+1;j<10;j++)
              {
                  if(arr[i]==arr[j])
                      arr[i]=42;
              }
        }
        for(int i=0;i<10;i++)
        {
             if(arr[i]!=42)
                 count++;
        }
        System.out.print(count);
    }
}