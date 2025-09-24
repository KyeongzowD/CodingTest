class Solution {
    public int solution(int n) {
        int answer = 0;
        int j=0;//f(0)
        int k=1;//f(1)
        for(int i=1;i<n-1;i++){
            if(i%2==1){
                j+=k;
                j%=1234567;
            }else{
                k+=j;
                k%=1234567;
            }
        }
        answer=(k+j)%1234567;
        
        return answer;
    }
}