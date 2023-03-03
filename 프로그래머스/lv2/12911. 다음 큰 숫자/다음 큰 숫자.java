import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String S=Integer.toBinaryString(n);
        
        int one=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='1'){one++;}
        }
        
        if(S.contains("0")){//0이 포함이 되어있는 경우
            for(int i=0;i<S.length();i++){
                if(S.charAt(S.length()-1-i)=='0'){
                    continue;
                }else{
                    answer = Integer.parseInt(S, 2);//다시 10진수로 변환 후 
                    answer+=Math.pow(2,i);//1을 만나 더해짐
                    break;//벗어나서 부족한 1을 채워야 함
                }
            }
        }else{//0이 포함이 안되어있는 경우
            S="10";
            for(int i=0;i<one-1;i++){
                S+="1";
            }
            return Integer.parseInt(S, 2);
        }
        S=Integer.toBinaryString(answer);//더해진 수에서 필요한 1을 더해야함
        int re_one=0;//필요한 1의 갯수
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='1'){re_one++;}
        }
        for(int i=0;i<one-re_one;i++){
            answer+=(int)Math.pow(2,i);
        }
        return answer;
    }
}