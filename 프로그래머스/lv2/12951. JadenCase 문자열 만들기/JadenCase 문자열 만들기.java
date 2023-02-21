class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();//문자열을 문자 배열로
        
        int j=0;//j==0일 경우 단어의 첫번째 단어가 대문자인지 확인하고 나머지를 소문자로 변환
        for(int i=0;i<s.length();i++){
            if(arr[i]==32){//문자가 숫자일 경우, 공백일 경우
                answer+=Character.toString(arr[i]);
                j=0;
            }else if(j==0){//arr[i]가 대문자여야 함
                if(arr[i]>96){//소문자일 경우 변환 후 입력
                    answer+=Character.toString((char)((int)arr[i]-32));
                }else{//이미 대문자일 경우
                    answer+=Character.toString(arr[i]);
                }
                j=1;
            }else{
                if(arr[i]<96){
                    answer+=Character.toString((char)((int)arr[i]+32));
                }else{
                    answer+=Character.toString(arr[i]);
                }
                    
            }
        }
        
        return answer;
    }
}