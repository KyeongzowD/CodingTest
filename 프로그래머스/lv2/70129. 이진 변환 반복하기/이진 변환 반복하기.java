class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt=0;//변환한 횟수
        int zero=0;//지워진 0의 갯수
        
        while(s.length()>1){
            String two="";//1만 남은 이진법
            int ten;//two를 십진법으로 변환
            for(int i=0;i<s.length();i++){//1만 남겨놓고 없앤 0의 수 세기
                if(s.charAt(i)=='1'){//s.charAt(i)==1일 경우
                    two+="1";
                }else{//==0일 경우
                    zero++;
                }  
            }//two을 이진법으로 변환해서 10진수의 숫자로
            ten=two.length();//이진수 two의 길이 입력
            s=Integer.toBinaryString(ten);//십진수fh
            
            cnt++;
        }
        answer[0]=cnt;
        answer[1]=zero;
        
        return answer;
    }
}