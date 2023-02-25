import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> arr=new HashSet<>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                
                arr.add(numbers[i]+numbers[j]);
            }
        }
        
        answer=new int[arr.size()];
        Iterator iter = arr.iterator();
        
        for(int i=0;i<arr.size();i++){
            answer[i]=(int)iter.next();
        }
        Arrays.sort(answer);
        
        return answer;
    }
}