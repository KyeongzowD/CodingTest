class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if(n>m){
            int tmp=n;
            n=m;
            m=tmp;
        }
        //최대공약수
        for(int i=1;i<n+1;i++){
            if((n%i==0)&&(m%i==0)){
                answer[0]=i;
            }
        }
        
        //최대공배수
        for(int i=n*m;i>0;i--){
            if((i%n==0)&&(i%m==0)){
                answer[1]=i;
            }
        }
        return answer;
    }
}