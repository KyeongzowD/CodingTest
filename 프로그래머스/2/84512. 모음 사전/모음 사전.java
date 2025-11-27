class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] dist=new int[]{781,156,31,6,1};
        String aeiou="AEIOU";
        
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            int idx=aeiou.indexOf(c);
            
            answer+=idx*dist[i]+1;
        }
        return answer;
    }
}