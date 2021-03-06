import java.util.*;
import java.math.*;
import java.io.*;

public class Luck{
	public static InputReader sc;
    public static PrintWriter out;
    public static final int MOD = (int) (1e9 + 7);
    public static void main(String[] args){
    	sc=new InputReader(System.in);	
    	out=new PrintWriter(System.out);
    	int n=sc.nextInt();
    	int[] A=new int[n+1];
    	int sum=0;
    	for(int i=1;i<=n;i++){
    		A[i]=sc.nextInt();
    		sum+=A[i];
    	}
    	sum=(sum)/(n/2);
    	for(int i=1;i<=n;i++){
    		if(A[i]!=-1){
    			for(int j=i+1;j<=n;j++){
    				if(A[i]+A[j]==sum){
    					A[j]=-1;
    					out.println(i+" "+j);
    					break;
    				}
    			}
    		}
    	}
    	out.close();
    }
  
    static int gcd(int a,int b){
    	if(b==0){
    		return a;
    	} 
    	return gcd(b,a%b);
    }
    static int lcm(int a,int b){
    	int g;
    	if(a<b){
    		g=gcd(b,a);
    	}
    	else{
    		g=gcd(a,b);
    	}
    	return (a*b)/g;
    }
    
    static boolean isPrime(int n){
    	 if (n == 2)
    	        return true;
    	    for (long i = 2; i * i <= n; i++) {
    	        if (n % i == 0)
    	            return false;
    	    }
    	    return true;
    }
    
    static void shuffle(int[] A){
    	for(int i=A.length-1;i>0;i--){
    		int j=(int)(Math.random()*(i+1));
    		int temp=A[j];
    		A[j]=A[i];
    		A[i]=temp;
    	}
    }
    
	public static class Node implements Comparable<Node>{
	    int next;
	    int dist;
	    
	    public Node (int u, int v) {
	        this.next = u;
	        this.dist = v;
	    }
	    
	    public void print() {
	        out.println(next + " " + dist + " ");
	    }
	    
	    public int compareTo(Node n) {
	        return Integer.compare(-this.next, -n.next);
	    }
	}

	public static BigInteger pow(BigInteger base, BigInteger exp) {
	    if(exp.equals(new BigInteger(String.valueOf(0)))){
	        return new BigInteger(String.valueOf(1));
	    }    
	    if(exp.equals(new BigInteger(String.valueOf(1))))
	        return base;
	    BigInteger temp=exp.divide(new BigInteger(String.valueOf(2)));
	    BigInteger val = pow(base, temp);
	    BigInteger result = val.multiply(val);
	    result=result.remainder(new BigInteger(String.valueOf(MOD)));
	    BigInteger AND=exp.and(new BigInteger(String.valueOf(1)));
	    if(AND.equals(new BigInteger(String.valueOf(1)))){
	        result = result.multiply(base);
	        result=result.remainder(new BigInteger(String.valueOf(MOD)));
	    }    
	    return result;
	}
	    
	static class InputReader {

	    private InputStream stream;
	    private byte[] buf = new byte[8192];
	    private int curChar, snumChars;
	    private SpaceCharFilter filter;

	    public InputReader(InputStream stream) {
	        this.stream = stream;
	    }

	    public int snext() {
	        if (snumChars == -1)
	            throw new InputMismatchException();
	        if (curChar >= snumChars) {
	            curChar = 0;
	            try {
	                snumChars = stream.read(buf);
	            } catch (IOException e) {
	                throw new InputMismatchException();
	            }
	            if (snumChars <= 0)
	                return -1;
	        }
	        return buf[curChar++];
	    }

	    public int nextInt() {
	        int c = snext();
	        while (isSpaceChar(c))
	            c = snext();
	        int sgn = 1;
	        if (c == '-') {
	            sgn = -1;
	            c = snext();
	        }
	        int res = 0;
	        do {
	            if (c < '0' || c > '9')
	                throw new InputMismatchException();
	            res *= 10;
	            res += c - '0';
	            c = snext();
	        } while (!isSpaceChar(c));
	        return res * sgn;
	    }

	    public long nextLong() {
	        int c = snext();
	        while (isSpaceChar(c))
	            c = snext();
	        int sgn = 1;
	        if (c == '-') {
	            sgn = -1;
	            c = snext();
	        }
	        long res = 0;
	        do {
	            if (c < '0' || c > '9')
	                throw new InputMismatchException();
	            res *= 10;
	            res += c - '0';
	            c = snext();
	        } while (!isSpaceChar(c));
	        return res * sgn;
	    }

	    public int[] nextIntArray(int n) {
	        int a[] = new int[n];
	        for (int i = 0; i < n; i++)
	            a[i] = nextInt();
	        return a;
	    }

	    public String readString() {
	        int c = snext();
	        while (isSpaceChar(c))
	            c = snext();
	        StringBuilder res = new StringBuilder();
	        do {
	            res.appendCodePoint(c);
	            c = snext();
	        } while (!isSpaceChar(c));
	        return res.toString();
	    }

	    public boolean isSpaceChar(int c) {
	        if (filter != null)
	            return filter.isSpaceChar(c);
	        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	    }

	    public interface SpaceCharFilter {
	        public boolean isSpaceChar(int ch);
	    }
	}

}
