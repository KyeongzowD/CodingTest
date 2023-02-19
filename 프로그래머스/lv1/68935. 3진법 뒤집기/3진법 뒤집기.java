import java.lang.StringBuffer;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb=new StringBuffer();
        
        sb.append(Integer.toString(n,3));
        sb.reverse();
        String S=sb.toString();
        answer=(Integer.parseInt(S,3));
        return answer;
    }
}