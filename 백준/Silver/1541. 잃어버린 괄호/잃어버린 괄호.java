import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] arr = S.split("[+-]");
        int answer = Integer.parseInt(arr[0]);
        boolean b = false;

        for (int i = 1; i < arr.length; i++) {
            S=S.substring(arr[i-1].length());
            if (S.charAt(0) == '-'||b) {
                b = true;
                answer-=Integer.parseInt(arr[i]);
            }else {
                answer+=Integer.parseInt(arr[i]);
            }
            S=S.substring(1);
        }
        System.out.println(answer);
    }
}
