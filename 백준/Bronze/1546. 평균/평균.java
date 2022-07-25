import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int number=sc.nextInt();
        int[] arr=new int[number];
        for(int i=0;i<number;i++)//점수입력받기
        {
            arr[i]=sc.nextInt();
        }
        int max=arr[0];
        for(int i=1;i<number;i++)//큰 수 출력
        {
            if(max<arr[i])
                max=arr[i];
        }
        int hap=0;
        for(int i=0;i<number;i++)
        {
            hap+=arr[i];
        }
        System.out.print((float)(hap*100)/(max*number));
    }
}