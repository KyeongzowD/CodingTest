import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();//큰 값
        int y=sc.nextInt();//작은 값
        int max=(x>y)?x:y;
        int min=(x>y)?y:x;
        for(int i=1;i<min+1;i++){
            if((max%i==0)&&(min%i==0))
                y=i;
        }
        for(int i=min*max;i>=max;i--){
            if((i%max==0)&&(i%min==0)){
                x=i;
            }
        }
        System.out.println(y);
        System.out.println(x);
	}
}