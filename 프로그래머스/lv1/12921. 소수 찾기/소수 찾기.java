import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr=new int[n+1];
        
        arr[0]=1;arr[1]=1;
        for(int i=2;i<Math.sqrt(n);i++){
            for(int j=2;i*j<n+1;j++)
                arr[i*j]=1;
        }
        
        for(int i=0;i<n+1;i++){
            if(arr[i]!=1)
                answer++;
        }
        
        return answer;
    }
}