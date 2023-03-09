class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int k=0;
        for(int i=0;i<wallpaper.length;i++){//y축
            for(int j=0;j<wallpaper[0].length();j++){//x축
                if(wallpaper[i].charAt(j)=='#'){
                    if(k==0){//첫 등록
                        answer[0]=i;answer[1]=j;
                        answer[2]=i;answer[3]=j;
                        k++;
                    }
                    
                    if(i<answer[0]){//y축 비교
                        answer[0]=i;
                    }else if(i>answer[2]){
                        answer[2]=i;
                    }
                    
                    if(j<answer[1]){//x축 비교
                        answer[1]=j;
                    }else if(j>answer[3]){
                        answer[3]=j;
                    }
                }
            }
        }    
        answer[2]++;answer[3]++;
        
        return answer;
    }
}