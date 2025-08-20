import java.io.*;

public class Main {
    static boolean ans;
    static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 s를 t로 변환하는 문제 (역추적)
        s = br.readLine();
        t = br.readLine();
        aAndB(t);

        if (ans) bw.write("1");
        else bw.write("0");
        bw.flush();
    }

    static void aAndB(String string) {
        if(string.isEmpty()) return;
        if(string.equals(s)){
            ans = true;
            return;
        }

        if (string.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(string.substring(1));
            aAndB(sb.reverse().toString());
        }

        if (string.charAt(string.length() - 1) == 'A')
            aAndB(string.substring(0, string.length()-1));
    }
}
