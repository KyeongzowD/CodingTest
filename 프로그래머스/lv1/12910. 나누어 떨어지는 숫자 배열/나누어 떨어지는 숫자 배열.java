import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> alist=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0)
                alist.add(arr[i]);
        }
        
        if(alist.size()==0){
            answer=new int[1];
            answer[0]=-1;
        }else{
            answer=new int[alist.size()];
            for(int i=0;i<alist.size();i++){
                answer[i]=alist.get(i);
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}