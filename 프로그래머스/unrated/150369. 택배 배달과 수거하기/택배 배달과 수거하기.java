class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delivery=0;
        int pickup=0;
      
        int del_i=0;
        int pic_i=0;

        for(int i=n-1;i>=-1;i--){
            if(i==-1){
                del_i=-1;
                break;
            }
            if(deliveries[i]!=0){
                del_i=i;
                break;
            }
        }
      
        for(int i=n-1;i>=-1;i--){
            if(i==-1){
                pic_i=-1;
                break;
            }
            if(pickups[i]!=0){
                pic_i=i;
                break;
            }
        }
        
        while((del_i>=0)||(pic_i>=0)){
          
            if(del_i>=pic_i){
                answer+=(del_i+1)*2;
            }else{
                answer+=(pic_i+1)*2;
            }
            
            
            while(del_i>=0){    
                deliveries[del_i]--;//del_i+1번째의 집에서 택배 하나 수거
                delivery++;//위에서 수거한 택배 하나
              
                while(deliveries[del_i]==0){//배달해야하는 집의 택배가 0일 경우 다음 집
                    del_i--;
                    if(del_i==-1){break;}
                }
              
                if(del_i==-1){break;}
                
                if(delivery==cap){
                    delivery=0;
                    break;
                }
            }
            
            while(pic_i>=0){
                pickups[pic_i]--;
              
                while(pickups[pic_i]==0){//수거해야하는 집의 택배가 0일 경우 다음 집
                    pic_i--;  
                    if(pic_i==-1){break;}
                }
                if(pic_i==-1){break;}
                
                pickup++;
                if(pickup==cap){
                    pickup=0;
                    break;
                }
            }
        }
        
        return answer;
    }
}