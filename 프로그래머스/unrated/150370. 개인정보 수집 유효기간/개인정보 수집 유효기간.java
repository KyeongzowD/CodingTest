import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LinkedList<Integer> arr=new LinkedList<>();

        String[] today_S=today.split("\\.");

        int[] today_i=new int[3];
        for(int i=0;i<3;i++){
          today_i[i]=Integer.parseInt(today_S[i]);
        }

        int[][] pri=new int[privacies.length][3];
        for(int i=0;i<privacies.length;i++){
          privacies[i]=privacies[i].replace(" ",".");
          String[] S=privacies[i].split("\\.",4);
          pri[i][0]=Integer.parseInt(S[0]);
          pri[i][1]=Integer.parseInt(S[1]);
          pri[i][2]=Integer.parseInt(S[2])-1;
          if(pri[i][2]==0){
            pri[i][2]=28;
            pri[i][1]-=1;
            if(pri[i][1]==0){
              pri[i][1]=12;
              pri[i][0]-=1;
            }
          }
        }

        for(int i=0;i<privacies.length;i++){
          char S=privacies[i].charAt(privacies[i].length()-1);//개인별 약관 종류

          for(int k=0;k<terms.length;k++){//개인 기간에 유효기간(달) 더하기
            String[] charr=terms[k].split(" ");

            if(charr[0].equals(Character.toString(S))){
                pri[i][1]+=Integer.parseInt(charr[1]);
                break;
            }
          }
            
          while(pri[i][1]>12){//유효기간 계산
                    pri[i][0]++;
                    pri[i][1]-=12;
          }
            
          if(today_i[0]>pri[i][0]){//오늘의 연도가 유효기간의 연도보다 클 때
            arr.add(i+1);
          }else if(today_i[0]==pri[i][0]){//오늘의 연도가 유효기간의 연도와 같을 때
            if(today_i[1]>pri[i][1]){//오늘의 달이 유효기간의 달보다 클 때
              arr.add(i+1);
            }else if(today_i[1]==pri[i][1]){//오늘의 달이 유효기간의 달와 같을 때
              if(today_i[2]>pri[i][2]){
                arr.add(i+1);
              }
            }
          }
        }

        int[] answer=new int[arr.size()];

        for(int i=0;i<arr.size();i++){
          answer[i]=arr.get(i);
        }
        return answer;
    }
}