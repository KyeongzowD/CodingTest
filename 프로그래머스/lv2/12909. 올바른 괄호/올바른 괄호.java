import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }else{
                if(st.size()==0){
                    answer=false;
                    break;
                } 
                st.pop();
            }
        }if(st.empty()==false){
            answer=false;
        }
        return answer;
    }
}