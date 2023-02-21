class Solution {
    public String solution(String s) {
        String answer = "";
        int min, max;
        
        String[] ArraysStr = s.split(" ");
        int[] arr=new int[ArraysStr.length];
        
        for(int i=0;i<ArraysStr.length;i++){
            arr[i]=Integer.parseInt(ArraysStr[i]);
        }
        
        min=arr[0];
        max=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        
        answer+=Integer.toString(min);
        answer+=" ";
        answer+=Integer.toString(max);
        return answer;
    }
}