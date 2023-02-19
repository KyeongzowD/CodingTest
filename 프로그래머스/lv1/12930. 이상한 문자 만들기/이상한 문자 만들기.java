import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr=s.toCharArray();
        
        int j=0;
        for(int i=0;i<s.length();i++){
            if(arr[i]==' '){
                j=0;
                continue;
            }
            if(j%2==0){//대문자로 변환
                if(arr[i]>96)
                    arr[i]=(char)((int)arr[i]-32);
            }else{//소문자로 변환
                if(arr[i]<96)
                    arr[i]=(char)((int)arr[i]+32);
            }
            j++;
        }
        
        for(int i=0;i<s.length();i++){
            answer+=arr[i];
        }
        
        return answer;
    }
}