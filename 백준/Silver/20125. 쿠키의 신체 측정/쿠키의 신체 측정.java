import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        int y = -1, x = -1; // 팔 위치의 y 좌표, 몸통 위치의 x 좌표

        for (int i = 0; i < N; i++) { // 쿠키 신체 입력
            String string = br.readLine();
            for (int j = 0; j < N; j++) {
                if(string.charAt(j)=='*')
                    arr[i][j] = true;

                if (y == -1 && j - 1 > 0 && arr[i][j] == arr[i][j - 1] && arr[i][j])
                    y = i;
                if (x == -1 && i - 1 > 0 && arr[i][j] == arr[i - 1][j] && arr[i][j])
                    x = j;
            }
        }

        int left = 0, right = 0, middle = 0, leftLeg = 0, rightLeg = 0;
        for (int j = 0; j < N; j++) {
            if (j < x && arr[y][j])
                left++;
            else if (x < j && arr[y][j])
                right++;
        }

        for (int i = y; i < N; i++) {
            if(!arr[i][x]) break;
            middle++;
        }

        for (int i = y + middle; i < N; i++) {
            if(arr[i][x-1]) leftLeg++;
            if(arr[i][x+1]) rightLeg++;
        }


        bw.write(String.valueOf(y+1) + " " + String.valueOf(x+1));
        bw.newLine();
        bw.write(String.valueOf(left)+" "+String.valueOf(right)+" "+String.valueOf(middle-1)+" "+String.valueOf(leftLeg)+" "+String.valueOf(rightLeg));
        bw.flush();
    }
}