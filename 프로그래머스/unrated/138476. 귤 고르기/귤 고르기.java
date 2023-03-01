import java.util.Arrays;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        int[] arr=new int[tangerine[tangerine.length-1]];//최대값
        for(int i=0;i<tangerine.length;i++){
            arr[tangerine[i]-1]++;
        }
        Arrays.sort(arr);
        
        int sum=0;int i=arr.length-1;
        while(sum<k){
            if(arr[i]>k){
                answer=1;
                break;
            }else{
                sum+=arr[i];
                i--;
                answer++;
            }
            
        }
        return answer;
    }
}