import java.util.*;
import java.lang.*;
public class Main{
	public static void main(String[] args) throws EmptyStackException {
		Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        String[] arr=new String[N];
        for(int i=0;i<N;i++){
            Stack<Character> st=new Stack<Character>(); 
            arr[i]="YES";
            String S=sc.next();
            for(int j=0;j<S.length();j++){
                if(S.charAt(j)=='('){
                    st.push('(');
                }
                else{
                    if(st.empty()==true){
                        arr[i]="NO";
                        break;
                    }
                    st.pop();
                }
            }
            if(st.empty()==false){
                arr[i]="NO";
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }
	}
}