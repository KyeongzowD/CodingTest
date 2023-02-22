class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            String S1=Integer.toBinaryString(arr1[i]); 
            String S2=Integer.toBinaryString(arr2[i]); 
            
            while(S1.length()!=n){
                S1="0"+S1;
            }
            while(S2.length()!=n){
                S2="0"+S2;
            }
            
            answer[i]="";
            for(int j=0;j<n;j++){
                if((S1.charAt(j)=='1')||(S2.charAt(j)=='1')){
                    answer[i]+="#";
                }else{
                    answer[i]+=" ";
                }
            }
        }
        return answer;
    }
}