import java.util.Scanner;
public class Main
{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int []arr = new int[9]; 
      for(int i=0;i<9;i++){
         arr[i] = sc.nextInt(); 
      }
       sc.close();
       int max=arr[0];
       int num=1;
       for(int j=1;j<9;j++){
         if(max<arr[j]){
             max = arr[j];
             num = j+1;
         }
      }
      System.out.println(max);
      System.out.println(num);
   }
}