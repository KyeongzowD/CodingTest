class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String s="";
        for(int i=0;i<t*m;i++){
            s=s+Integer.toString(i,n);
        }
        
        for(int i=0;i<t;i++){
            char c=s.charAt(p-1+m*i);
            if(c>96){c-=32;}
            answer+=Character.toString(c);
        }
        return answer;
    }
}