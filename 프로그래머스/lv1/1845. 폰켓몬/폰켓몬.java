import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                answer++;
            }
        }
        if(nums.length/2<answer){
            answer=nums.length/2;
        }
        return answer;
    } 
}