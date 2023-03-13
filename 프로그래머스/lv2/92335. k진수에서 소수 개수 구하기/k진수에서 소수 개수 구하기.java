import java.util.LinkedList;
import java.lang.Math;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        LinkedList<Long> arr=new LinkedList<>();
        
        String s=Integer.toString(n,k);
        String pri="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(pri.length()!=0){
                    arr.add(Long.parseLong(pri));
                    answer++;
                }
                pri="";
            }else{
                pri+=Character.toString(s.charAt(i));
            }
        }
        if(pri.length()!=0){
            arr.add(Long.parseLong(pri));
            answer++;
        }
        
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==(long)1){
                    answer--;
                    break;
                }
            for(int j=2;j<Math.sqrt(arr.get(i))+1;j++){
                
                if((arr.get(i)%j==0)&&(arr.get(i)!=j)){//나누어지지만 같은 수는 안됨
                    answer--;
                    break;//ex) 2%2
                }
            }
        }
        
        return answer;
    }
}