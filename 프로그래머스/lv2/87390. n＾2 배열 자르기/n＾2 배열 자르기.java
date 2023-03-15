class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
        
        for(int i=0;i<answer.length;i++){//answer의 크기만큼 반복
            long a=(left+i)/n;
            long b=(left+i)%n;
            answer[i]=((int)a>(int)b)?(int)a+1:(int)b+1;
        }
        
        return answer;
    }
}