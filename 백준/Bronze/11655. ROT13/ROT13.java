import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        String S=sc.nextLine();
        String answer="";
        for(int i=0;i<S.length();i++){
            if((S.charAt(i)>=78)&&(S.charAt(i)<=91)||(S.charAt(i)>=110)&&(S.charAt(i)<=123)){
                answer+=(char)(S.charAt(i)-13);
            }else if((S.charAt(i)>47)&&(S.charAt(i)<=57)||(S.charAt(i)==' ')){
                answer+=(char)(S.charAt(i));
            }else{
                answer+=(char)(S.charAt(i)+13);
            } 
        }
        System.out.println(answer);
	}
}