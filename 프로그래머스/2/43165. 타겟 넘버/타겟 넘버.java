class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    
    static void dfs(int[] numbers, int depth, int target, int sum){
        if(depth==numbers.length){
            if(sum==target) answer++;
            return;
        }
        
        dfs(numbers, depth+1, target, sum+numbers[depth]);
        dfs(numbers, depth+1, target, sum-numbers[depth]);
    }
}