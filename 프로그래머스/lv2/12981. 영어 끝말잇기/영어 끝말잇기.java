class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int i;
        for(i=1;i<words.length;i++){
            answer[0]=i%n+1;//번호
            answer[1]=i/n+1;//차례
            if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){//앞사람과 끝말잇기에 실패했을 경우
                break;
            }
            for(int j=0;j<i;j++){
                if(words[j].equals(words[i])){
                    return answer;
                }
            }
        }
        
        if((answer[0]==n)&&(answer[1]==words.length/n)){
            answer[0]=0;answer[1]=0;
        }

        return answer;
    }
}