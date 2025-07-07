import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] arr = {"a", "e", "i", "o", "u"};

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) { break; }
            boolean accept=true;
            int len = str.length();

            for (int i = 0; i < 5; i++) { // 모음 하나는 반드시 포함
                if(str.contains(arr[i])) { break; }
                if(i==4) { accept = false; }
            }

            for (int i = 0; i < len - 2 && accept; i++) { // 모음이 3개 혹은 자음이 3개 연속 금지
                if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                    if(str.charAt(i+1)=='a'||str.charAt(i+1)=='e'||str.charAt(i+1)=='i'||str.charAt(i+1)=='o'||str.charAt(i+1)=='u'){
                        if(str.charAt(i+2)=='a'||str.charAt(i+2)=='e'||str.charAt(i+2)=='i'||str.charAt(i+2)=='o'||str.charAt(i+2)=='u'){
                            accept = false;
                            break;
                        }
                    }
                }
                if(str.charAt(i)!='a'&&str.charAt(i)!='e'&&str.charAt(i)!='i'&&str.charAt(i)!='o'&&str.charAt(i)!='u'){
                    if(str.charAt(i+1)!='a'&&str.charAt(i+1)!='e'&&str.charAt(i+1)!='i'&&str.charAt(i+1)!='o'&&str.charAt(i+1)!='u'){
                        if(str.charAt(i+2)!='a'&&str.charAt(i+2)!='e'&&str.charAt(i+2)!='i'&&str.charAt(i+2)!='o'&&str.charAt(i+2)!='u'){
                            accept = false;
                        }
                    }
                }

            }

            for (int i = 0; i < len - 1 && accept; i++) { // 같은 글자 연속 금지 (ee, oo는 허용)
                if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) != 'e' && str.charAt(i) != 'o') {
                    accept = false;
                }
            }

            if(accept){
                sb.append("<").append(str).append("> is acceptable.\n");
            }else {
                sb.append("<").append(str).append("> is not acceptable.\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}