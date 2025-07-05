import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a=1, b=1, c=1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {break;}

            if(a==b&&b==c){
                bw.write("Equilateral");
            }else if(a+b<=c||a+c<=b||c+b<=a){
                bw.write("Invalid");
            }else if(a==b||b==c||c==a){
                bw.write("Isosceles");
            }else{
                bw.write("Scalene");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
