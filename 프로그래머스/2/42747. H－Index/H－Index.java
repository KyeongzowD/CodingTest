import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int n=citations.length;
        
        for(int i=0;i<n;i++){
            int j=n-i;
            if(citations[i]>=j){
                return j;
            }
        }
        
        return 0;
    }
}