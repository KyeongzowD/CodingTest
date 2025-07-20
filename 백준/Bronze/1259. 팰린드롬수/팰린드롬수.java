import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if(str.equals("0")) break;

            boolean palindrpme = true;
            for (int i = 0; i < str.length()/2; i++) {
                if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
                    palindrpme = false;
                    break;
                }
            }

            if(palindrpme) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}