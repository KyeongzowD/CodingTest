import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int len=number.length();
        char[] stack=new char[len];
        int t=0;
        
        for(int i=0;i<len;i++){
            char c=number.charAt(i);
            
            while(t>0 && k>0 && stack[t-1]<c){
                t--;
                k--;
            }
            
            stack[t++]=c;
        }
            
        return new String(stack,0,t-k);
    }
}