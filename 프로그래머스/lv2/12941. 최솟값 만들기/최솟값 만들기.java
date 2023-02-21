import java.util.Arrays;
import java.util.Collections;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        
        Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[] :: new);
      // 내림차순 정렬
        Arrays.sort(arrB, Collections.reverseOrder());
        
        for(int i=0;i<A.length;i++){
            answer+=A[i]*arrB[i];
        }
        

        

        return answer;
    }
}