import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int[] Eng=new int[26];
        //{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String st=sc.next();//문자입력받기
        int count=0;
        int ind=0;//max인 배열의 인덱스 값
        for(int i=0;i<st.length();i++)//인덱스에 알파벳 나온 수 입력
        {
            if((int)st.charAt(i)<97)
                Eng[(int)st.charAt(i)-65]++;
            else
                Eng[(int)st.charAt(i)-97]++;
        }
        int max=Eng[0];//최대 많이 나온 문자의 횟수
        for(int i=1;i<26;i++)//가장 많이 사용한 문자의 인덱스 출력
        {
            if(max<Eng[i])
            {
                max=Eng[i];
                ind=i;
            }
        }
        for(int i=0;i<26;i++)
        {
            if(max==Eng[i])
                count++;
        }
        if(count>1)
            System.out.print("?");
        else
        {
            char c=(char)(ind+65);
            System.out.print(c);
        }
    }
}