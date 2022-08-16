class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wid=0;
        int hei=0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                int temp=sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
        }
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][1]>wid){wid=sizes[i][1];}
            if(sizes[i][0]>hei){hei=sizes[i][0];}
        }
        answer=wid*hei;
        return answer;
    }
}