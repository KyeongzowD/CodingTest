import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer=1;
        HashMap <String,Integer> map= new HashMap<String,Integer>();
        for(int i=0;i<clothes.length;i++){//옷의 종류++
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }else{
                map.put(clothes[i][1],1);
            }
        }
        ArrayList <Integer> arr=new ArrayList<Integer>(map.values());
        for(int i=0;i<arr.size();i++){
            answer*=(1+arr.get(i));
        }
        return answer-1;
    }
    
}