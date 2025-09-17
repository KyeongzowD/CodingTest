class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int y1Len = arr1.length; 
        int x1Len = arr1[0].length;
        int y2Len = arr2[0].length; 

        int[][] answer = new int[y1Len][y2Len];

        for (int i = 0; i < y1Len; i++) { 
            for (int j = 0; j < y2Len; j++) {   
                int total = 0;
                for (int k = 0; k < x1Len; k++) { 
                    total += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = total;
            }
        }
        return answer;
    }
}