public class Main{

	public static void main(String[] args) {
		boolean[] arr=new boolean[10000];
        for(int i=1; i<10000;i++)
        {
            int a=sival(i);
            
            if(a<10000)
                arr[a]=true;
        }
        for(int i=1;i<10000;i++)
        {
            if(arr[i]==false)
                System.out.println(i);       
        }
	}
    public static int sival(int n)
    {
        int sum=n;
        while(n!=0)
        { 
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}