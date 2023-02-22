class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] arr=s.toCharArray();
        
        for(int i=0;i<s.length();i++){
            if(((arr[i]<91)&&(arr[i]+n>90))||(arr[i]+n>122)){
                arr[i]-=26;
            }else if(arr[i]==32){
                answer+=" ";
                continue;
            }
            answer+=Character.toString((char)((int)arr[i]+n));
        }
        return answer;
    }
}