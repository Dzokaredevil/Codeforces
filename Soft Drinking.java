import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

public class P151A {
    static BigInteger ways(int N,  int K) {
        BigInteger ret = BigInteger.ONE;
        for(int i=N;i>=N-K+1;i--)
        {
             ret = ret.multiply(BigInteger.valueOf(i));
            
        }
        for (int j = 1; j<=K; j++) {
            ret = ret.divide(BigInteger.valueOf(j));
        }
       
            ret=ret.mod(BigInteger.valueOf(1000000007));
        
        return ret;
    }
    public static int prime(int n)
    {
        int f=1;
        if(n==1)
            return 0;
        for(int i=2;i<=(Math.sqrt(n));)
        {
            if(n%i==0)
            {
                f=0;
                break;
            }
            if(i==2)
                i++;
            else
                i+=2;
        }
        if(f==1)
            return 1;
        else 
            return 0;
    }

    public static BigInteger fact(int n)
    {
        BigInteger f=BigInteger.ONE;
        for(int i=1;i<=n;i++)
        {
            f=f.multiply(BigInteger.valueOf(i));
        }

        return f;
    }
public static int gcd(int x,int y)
{
    if(x%y==0)
        return y;
    else return gcd(y,x%y);
}
public static int max(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}
public static long min(long a,long b)
{
    if(a>b)
        return b;
    else 
        return a;
}



    public static void main(String[] args) throws Exception{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder("");
        
        String l[]=br.readLine().split(" ");
        
        int n=8;
        long ans=0;
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(l[i]);
        }

        long x=a[2]*a[1];
        x/=a[6];
        long y=a[3]*a[4];           
        long z=a[5]/a[7];
         ans=min(min(x,y),z);
         ans/=a[0];
         System.out.println(ans);

    }
}