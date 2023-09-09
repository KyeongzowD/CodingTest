import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Arrays.sort(clothes, Comparator.comparing((String[] o) -> o[1]));
        
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        int idx=0;//arr에 사용될 인덱스
        
        for(int i=1;i<clothes.length;i++){
            if(!clothes[i-1][1].equals(clothes[i][1])){
                arr.add(1);
                idx++;
            }else{
                arr.set(idx,arr.get(idx)+1);
            }
        }
        
        for(int i=0;i<arr.size();i++){
            answer*=arr.get(i)+1;
        }
        
        
        return answer-1;
    }
}