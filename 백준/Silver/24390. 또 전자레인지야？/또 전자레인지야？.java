import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    int cnt=0;

    String timer=br.readLine();
    int sec=Integer.parseInt(timer.substring(0,2))*60+Integer.parseInt(timer.substring(3,5));

    //10sec, 30sec(start), 1min(60sec), 10min(600sec)
    int[] button={0,0,0,0};

    while(sec>0){
      if(sec>=600){
        sec-=600;
        button[3]++;
      }
      else if(sec>=60){
        sec-=60;
        button[2]++;
      }
      else if(sec>=30){
        sec-=30;
        button[1]++;
      }
      else if(sec>=10){
        sec-=10;
        button[0]++;
      }
    }

    if(button[1]==0)
      cnt++;

    for(int i=0;i<4;i++){
      cnt+=button[i];
    }

    bw.write(Integer.toString(cnt));
    bw.flush();
    bw.close();
    br.close();
  }

}