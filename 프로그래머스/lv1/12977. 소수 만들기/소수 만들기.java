class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int[] arr=new int[3000];
        arr[0]=1;arr[1]=1;//소수가 아닌 수는 1
        for(int i=2;i<Math.sqrt(3000);i++){
            for(int j=2;j*i<3000;j++){
                arr[i*j]=1;
            }
        }
        
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(arr[nums[i]+nums[k]+nums[j]]==0)
                        answer++;
                }
            }
        }
        return answer;
    }
}