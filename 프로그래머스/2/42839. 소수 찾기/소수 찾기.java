import java.util.*;

class Solution {
    static boolean[] arr;
    static int[] nums;
    static boolean[] visited;
    static int ans=0;
    public int solution(String numbers) {
        int len=numbers.length();
        int number=Integer.parseInt(numbers);
        visited=new boolean[len];
        nums=new int[len];
        
        for(int i=0;i<len;i++){
            nums[i]=numbers.charAt(i)-48;
        }
        
        Arrays.sort(nums);
        int max=(nums[len-1]+1)*(int)Math.pow(10, len-1);
        arr=new boolean[max];
        
        for(int i=2;i<max;i++){ // 소수가 아닌 숫자들은 true 처리, 소수는 false
            for(int j=2; i*j<max;j++){
                arr[i*j]=true;
            }
        }
        arr[0]=true; arr[1]=true; arr[2]=false; arr[3]=false;
        
        for(int i=1; i< (1<<len); i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0; j<len;j++){
                if((i&(1<<j))!=0) list.add(nums[j]);
            }
            visited=new boolean[len];
            binaryCount(list);
        }
        
        return ans;
    }
    
    static void binaryCount(List<Integer> list){
        int len=list.size();
        
        for(int i=0;i<len;i++){
            visited[i]=true;
            dfs(list, i, len, 0);
            visited[i]=false;
        }
    }
    
    static void dfs(List<Integer> list,int idx, int depth, int sum){
        // 여기서 카운팅 된 소수는 true처리로 처리되었음 표시
        int len=list.size();
        sum=sum*10+list.get(idx);
        
        if(depth==String.valueOf(sum).length()){
            if(!arr[sum]){
                arr[sum]=true;
                ans++;
            }
            return;
        }
        
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(list, i, depth, sum);
                visited[i]=false;
            }
        }
    }
}