import java.io.*;

public class Main {
    static char[][] arr;
    static int N;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        N = Integer.parseInt(s); // 3 <= N <= 50
        arr = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < N - 1) {
                    // 세로로 교환
                    swap(i, j, i + 1, j);
                    checkBoard();
                    swap(i, j, i + 1, j); // 원상복구
                }
                if (j < N - 1) {
                    // 가로로 교환
                    swap(i, j, i, j + 1);
                    checkBoard();
                    swap(i, j, i, j + 1); // 원상복구
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static void checkBoard() {
        for (int i = 0; i < N; i++) {
            int rowCnt = 1;
            int colCnt = 1;
            for (int j = 1; j < N; j++) {
                // 행 체크
                if (arr[i][j] == arr[i][j - 1]) {
                    rowCnt++;
                } else {
                    rowCnt = 1;
                }
                answer = Math.max(answer, rowCnt);

                // 열 체크
                if (arr[j][i] == arr[j - 1][i]) {
                    colCnt++;
                } else {
                    colCnt = 1;
                }
                answer = Math.max(answer, colCnt);
            }
        }
    }
}