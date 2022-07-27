import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
	    int len=arr.length;
        int[] answer_NULL=new int[len];
        int j=0;
        for(int i=0;i<len-1;i++)
        {
            if(arr[i]!=arr[i+1]){
                answer_NULL[j]=arr[i];
                j++;
            }
        }
        answer_NULL[j]=arr[len-1];
        int[] answer=new int[j+1];
        for(int i=0;i<j+1;i++)
        {
            answer[i]=answer_NULL[i];
        }
        return answer;
    }
}