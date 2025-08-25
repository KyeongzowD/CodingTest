import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        char[][] game;
        while (!(str = br.readLine()).equals("end")){
            int cntO = 0, cntX = 0;
            game = new char[3][3];
            for (int i = 0; i < 9; i++) {
                game[i / 3][i % 3] = str.charAt(i);
                if (game[i / 3][i % 3] =='X')
                    cntX++;
                else if (game[i / 3][i % 3] =='O')
                    cntO++;
            }

            boolean valid = true;
            if (cntX > cntO + 1 || cntO > cntX) valid = false;

            char winner = ' ';
            for (int i = 0; i < 3 && valid; i++) {
                if (game[i][0] != '.' && game[i][0] == game[i][1] && game[i][2] == game[i][1]) {
                    if (winner == ' ')  // 초기 설정이거나 기존 우승자일 경우
                        winner = game[i][0];
                    else if(winner != game[i][0])
                        valid = false;
                }
            }
            for (int j = 0; j < 3 && valid; j++) {
                if (game[0][j] != '.' && game[0][j] == game[1][j] && game[1][j] == game[2][j]) {
                    if (winner == ' ')  // 초기 설정이거나 기존 우승자일 경우
                        winner = game[0][j];
                    else if (winner != game[0][j])
                        valid = false;
                }
            }
            if (game[0][0] != '.' && valid && game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
                if (winner == ' ')  // 초기 설정이거나 기존 우승자일 경우
                    winner = game[0][0];
                else if (winner != game[0][0])
                    valid = false;
            }
            if (game[2][0] != '.' && valid && game[0][2] == game[1][1] && game[2][0] == game[1][1]) {
                if (winner == ' ')  // 초기 설정이거나 기존 우승자일 경우
                    winner = game[0][2];
                else if (winner != game[0][2])
                    valid = false;
            }

            if (winner == 'X' && cntX != cntO + 1)
                valid = false;
            else if (winner == 'O' && cntO != cntX)
                valid = false;
            else if (winner == ' ' && cntO + cntX != 9)
                valid = false;

            if (valid) sb.append("valid\n");
            else sb.append("invalid\n");

        }

        bw.write(sb.toString());
        bw.flush();
    }
}
