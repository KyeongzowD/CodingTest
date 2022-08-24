import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int j=0;j<N;j++){
            int x=sc.nextInt();//큰 값
            int y=sc.nextInt();//작은 값
            int max=(x>y)?x:y;
            int min=(x>y)?y:x;
            for(int i=1;i<min+1;i++){
                if((max%i==0)&&(min%i==0))
                    arr[j]=min*max/i;
            }
        }
        for(int j=0;j<N;j++){
            System.out.println(arr[j]);
        }
        
	}
}