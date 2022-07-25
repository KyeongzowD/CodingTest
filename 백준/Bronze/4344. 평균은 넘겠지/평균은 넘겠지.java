import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int C=sc.nextInt();//C는 과목
        float ratio[]=new float[C];//배열 ratio는 평균을 넘는 학생의 비율
        for(int i=0;i<C;i++)//과목의 수만큼 돌리기
        {
        	float hap=0;//평균을 구하기 위한 합의 변수
            int N=sc.nextInt();//N은 학생의 수
            int[] score=new int[N];//score배열에 점수를 입력
            for(int j=0;j<N;j++)//배열에 입력하면서 변수hap에 평균을 위한 합 입력
            {
                score[j]=sc.nextInt();
                hap+=score[j];
            }//hap에 모든 점수의 합을 적고 score에 학생들의 점수가 등록
            hap/=N;//hap에 평균을 대입
            int count=0;
            for(int j=0;j<N;j++)//평균을 넘는 학생의 수 구하기
            {
                if(score[j]>hap)//평균을 넘는 학생은 count++
                	count++;
            }
            ratio[i]=((float)count/N)*100;
        }
        for(int i=0;i<C;i++)
        {
            System.out.println(String.format("%.3f",ratio[i])+"%");
        }
    }
}