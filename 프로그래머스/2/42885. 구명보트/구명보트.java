import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int N=people.length;
        int answer = N;
        
        Arrays.sort(people);
        for(int i=N-1,j=0;i>j;i--){
            if(people[i]+people[j]<=limit){ // 같이 탑승할 수 없는 경우
                j++;
                answer--;
            }
        }
        return answer;
    }
}