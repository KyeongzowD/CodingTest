class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        if(a>b){
            int tmp=a;
            a=b;
            b=tmp;
        } 
        
        
        //n=2의 answer승
        while(Math.pow(2,answer)!=n){answer++;}
        
        while((n/2<a)||(b<=n/2)){
            System.out.println("n="+n+" a="+a+" b="+b);
            answer--;
            n/=2;
            if((n<a)&&(n<b)){
                a-=n;
                b-=n;
            }
            if(n==2){break;}
        }
        
        
        return answer;
    }
}