import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (Integer.parseInt(br.readLine()) % 2 == 1) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
    }
}
