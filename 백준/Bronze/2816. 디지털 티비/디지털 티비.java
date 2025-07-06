import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int kbs1 = 0, kbs2 = 0;

        for (int i = 0; i < N; i++) {
            String channel = br.readLine();

            if (channel.equals("KBS1")) {
                kbs1 = i;
            }else if (channel.equals("KBS2")) {
                kbs2 = i;
            }
        }

        if(kbs2<kbs1){
            kbs2++;
        }
        sb.append("1".repeat(kbs1)).append("4".repeat(kbs1)).append("1".repeat(kbs2)).append("4".repeat(kbs2-1));
        bw.write(sb.toString());
        bw.flush();
    }
}