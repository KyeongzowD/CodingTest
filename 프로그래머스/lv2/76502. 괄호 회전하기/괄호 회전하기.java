import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        //(:1 ):2    {:3  }:4   [:5 ]:6
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                int k= (i+j >= s.length()) ? (i+j-s.length()) : (i+j);//k는 인덱스 값
                switch(s.charAt(k)){
                    case 40:
                        st.push(1);
                        break;
                        
                    case 123:
                        st.push(3);
                        break;
                        
                    case 91:
                        st.push(5);
                        break;
                        
                    case 41:
                        if((!st.empty())&&(st.peek()==1)){
                            st.pop();
                        }else{
                            st.push(2);
                        }
                        break;
                        
                    case 125:
                        if((!st.empty())&&(st.peek()==3)){
                            st.pop();
                        }else{
                            st.push(4);
                        }
                        break;
                        
                    case 93:
                        if((!st.empty())&&(st.peek()==5)){
                            st.pop();
                        }else{
                            st.push(6);
                        }
                        break;
                }
            }
            if(st.size()==0){answer++;}
            st.clear();
        }
        
        return answer;
    }
}