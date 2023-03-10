import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        Arrays.sort(strings);
        int k=0;
        for(int i=97;i<123;i++){
            for(int j=0;j<strings.length;j++){
                if(strings[j].charAt(n)==(i)){
                    answer[k]=strings[j];
                    k++;
                }
            }
        }
        
        
        
        return answer;
    }
}