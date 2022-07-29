class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int idx=0;
        int max=priorities[0];
        for(int k=0;k<priorities.length;k++){
	        if(max<priorities[k]){
	            max=priorities[k];
	            idx=k;
	        }
	    }
        int i=idx;
        for(int impo=max;impo>=priorities[location];impo--){
            for(int j=0;j<priorities.length;i++,j++){//fir_dix,idx에 대한 반복문
                
                if(i==priorities.length){
                    i=0;
                }
                if(impo==priorities[i]){//해당 중요도와 배열의 중요도가 같을 때 그 중요도의 인덱스 값을 저장
                    answer++;//중요도가 높은 것이 조건문에 count
                    idx=i;
                    if(idx==location){break;}
                }
            }i=idx;      
        }
        return answer;
    }
}