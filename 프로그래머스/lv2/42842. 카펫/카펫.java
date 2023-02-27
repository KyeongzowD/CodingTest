import java.lang.Math;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        answer[0]=((int)Math.sqrt((int)Math.pow((brown/2-2),2)-4*yellow)+brown/2-2)/2;
        answer[1]=yellow/answer[0]+2;
        answer[0]+=2;
        
        if(answer[0]<answer[1]){
            int tmp=answer[0];
            answer[0]=answer[1];
            answer[1]=tmp;
        }
        
        return answer;
    }
    
}