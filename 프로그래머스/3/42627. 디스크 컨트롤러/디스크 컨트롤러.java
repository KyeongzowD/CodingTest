import java.util.*;
class Solution {
    int time=0, len;
    int[] requireArray;
    PriorityQueue<Job> que=new PriorityQueue<>(
            Comparator.comparingInt((Job j) -> j.requiredTime)
            .thenComparingInt(j->j.requestTime)
            .thenComparingInt(j->j.num)
    );
    
    class Job{
        int num; // (3)
        int requestTime; // 요청 시간 (2)
        int requiredTime; // 소요 시간 (1)
        
        Job(int num, int requestTime, int requiredTime){
            this.num=num;
            this.requestTime=requestTime;
            this.requiredTime=requiredTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer=0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        len=jobs.length;
        requireArray=new int[len];
        
        for(int idx=0;idx<len;idx++){
            if(jobs[idx][0]<=time) {
                que.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
            }else{ //이전 작업을 모두 완료했다고 가정하고 함수 실행
                if(!que.isEmpty()){
                    working();  
                } else { // que에 값이 없고, time에 도달하지 않음
                    time=jobs[idx][0];
                }
                idx--; 
            }
        }
        
        while(!que.isEmpty()){
            working();
        }
        
        for(int i=0;i<len;i++){
            answer+=requireArray[i];
        }
        
        return answer/len;
    }
    
    void working(){
        Job job=que.poll();
        time+=job.requiredTime;
        requireArray[job.num]=time-job.requestTime;
    }

}