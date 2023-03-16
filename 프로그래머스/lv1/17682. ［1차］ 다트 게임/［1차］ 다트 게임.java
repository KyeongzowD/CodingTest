import java.lang.Math;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int a=0;
        int b=0;
        
        for(int i=0;i<dartResult.length();i++){
            char c=dartResult.charAt(i);
            if(c<58&&c>47){//숫자에 포함된 수가 아니면 계산식으로 
                b=a;
                a=Character.getNumericValue(c);
                if((i<dartResult.length()-1)&&(dartResult.charAt(i+1)=='0')){//점수가 10일 경우
                    a=10;
                    i++;
                }
                continue;
            }
            
            if(c=='S'){
                answer+=a;
            }else if(c=='D'){
                a=(int)Math.pow(a,2);
                answer+=a;
            }else if(c=='T'){
                a=(int)Math.pow(a,3);
                answer+=a;
            }else if(c=='*'){
                if((i<dartResult.length()-1)&&(dartResult.charAt(i+1)=='#')){
                    i++;
                    answer-=a;
                }else{
                    answer+=a+b;
                    a*=2;
                }
            }else if(c=='#'){
                answer-=a*2;//위에서 이미 더했으니 두번빼야 한다
                a=-a;
            }
        }
        return answer;
    }
}