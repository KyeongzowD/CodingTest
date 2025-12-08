import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> que=new PriorityQueue<>();
        PriorityQueue<Integer> revQue=new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str: operations){
            StringTokenizer st=new StringTokenizer(str);
            if(st.nextToken().charAt(0)=='I'){//큐에 숫자 삽입
                que.offer(Integer.parseInt(st.nextToken()));
            }else{
                if(que.isEmpty()) continue;
                
                if(st.nextToken().charAt(0)=='-'){//최솟값 삭제
                    que.poll();
                }else{//최댓값 삭제
                    revQue.addAll(que); que.clear();
                    revQue.poll();
                    que.addAll(revQue); revQue.clear();
                }
            }
        }
        
        if(!que.isEmpty()){
            answer[1]=que.peek();
            revQue.addAll(que);
            answer[0]=revQue.peek();
        }
        return answer;
    }
}