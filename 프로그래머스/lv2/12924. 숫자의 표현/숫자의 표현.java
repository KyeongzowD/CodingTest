class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum=0;
        int j=1;
        for(int i=1;i<=n;i++){
            sum+=i;
            if(sum==n){
                answer++;
            }else if(sum>n){
                j++;
                i=j;
                sum=0;
            }
        }
        if(n==2){answer=1;}
        
        return answer;
    }
}