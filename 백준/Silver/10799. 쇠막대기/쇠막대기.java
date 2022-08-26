import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        String S=sc.next();
        int answer=0;
        int count=0;//괄호의 갯수를 세기 위한 변수
        S=S.replace("()","|");
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                count++;
                answer++;
            }else if(S.charAt(i)==')'){
                count--;
            }else if(S.charAt(i)=='|'){
                answer+=count;
            }
        }
        System.out.println(answer);
	}
}