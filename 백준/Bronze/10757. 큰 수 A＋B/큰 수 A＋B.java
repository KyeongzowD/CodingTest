import java.util.Scanner;
import java.math.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        BigInteger a=new BigInteger("0");
        BigInteger b=new BigInteger("0");
        a=sc.nextBigInteger();
        b=sc.nextBigInteger();
        System.out.println(a.add(b));
	}
}
