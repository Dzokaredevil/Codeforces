import java.io.*;
	import java.math.BigInteger;
	import java.math.RoundingMode;
	import java.text.DecimalFormat;
	import java.util.*;
	
public class some {
		
	
		static double eps=(double)1e-6;
		static long mod=(int)1e9+6;
		
		public static void main(String args[]) throws IOException{
			InputReader sc = new InputReader(System.in);
			OutputStream outputStream = System.out;
			PrintWriter out = new PrintWriter(outputStream);
			//-------------------------------------
			
			int n = sc.nextInt();
			if(n%2==0)
			{
				int temp = n/2;
				out.println(temp);
				while(temp-- != 0)
					out.print(2 + " ");
			}
			else
			{
				int temp = (n-3)/2;
				out.println(temp+1);
				out.print(3 + " ");
				while(temp-- != 0)
					out.print(2 + " ");
			}
			//-------------------------------------
			out.close();
		}
		
		static boolean[] my_sieve(boolean[] b)
		{
			for(int i=2; i<b.length; i++)
			{
				if(!b[i])
				{
					for(int j = 2*i; j<b.length; j = j+i)
						b[j] = true;
				}
			}
			return b;
		}
		
		
		
		static boolean check(int x)
		{
			while(x!=0)
			{
				if(x%10==4 || x%10==7)
					x = x/10;
				else
					return false;
			}
			return true;
		}
		
		static class Pair implements Comparable<Pair> {
			int a, b;

			Pair(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				if (this.a != o.a)
					return Integer.compare(this.a, o.a);
				else
					return Integer.compare(this.b, o.b);
				//return 0;
			}

			public boolean equals(Object o) {
				if (o instanceof Pair) {
					Pair p = (Pair) o;
					return p.a == a && p.b == b;
				}
				return false;
			}

			public int hashCode() {
				return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
			}

			public String toString() {
				return a + " " + b;
			}
		}
		
		static int[] sieve(int n,int[] arr)
		{
			for(int i=2;i*i<=n;i++)
			{
				if(arr[i]==0)
				{
					for(int j=i*2;j<=n;j+=i)
						arr[j]=1;
				}
			}
			return arr;
		}
		
		static boolean isPal(String s)
		{
			for(int i=0, j=s.length()-1;i<=j;i++,j--)
			{
				if(s.charAt(i)!=s.charAt(j)) return false;
			}
			return true;
		}
		public static String rev(String s)
		{
			StringBuilder sb=new StringBuilder(s);
			sb.reverse();
			return sb.toString();
		}
		    
		static long lcm(long a, long b)
		{
		    return a * (b / gcd(a, b));
		}
		
		static long gcd(long a, long b)
		{
		    while (b > 0)
		    {
		        long temp = b;
		        b = a % b; // % is remainder
		        a = temp;
		    }
		    return a;
		}
		static long modulo(long a,long b,long c) {
			long x=1;
			long y=a;
			while(b > 0){
				if(b%2 == 1){
					x=(x*y)%c;
				}
				y = (y*y)%c; // squaring the base
				b /= 2;
			}
			return  x%c;
		}
		public static void debug(Object... o) {
			System.out.println(Arrays.deepToString(o));
		}
		
		static long sort(int a[]) {
			int n = a.length;
			int b[] = new int[n];
			return mergeSort(a, b, 0, n - 1);
		}

		static long mergeSort(int a[], int b[], long left, long right) {
			long c = 0;
			if (left < right) {
				long mid = left + (right - left) / 2;
				c = mergeSort(a, b, left, mid);
				c += mergeSort(a, b, mid + 1, right);
				c += merge(a, b, left, mid + 1, right);
			}
			return c;
		}

		static long merge(int a[], int b[], long left, long mid, long right) {
			long c = 0;
			int i = (int) left;
			int j = (int) mid;
			int k = (int) left;
			while (i <= (int) mid - 1 && j <= (int) right) {
				if (a[i] <= a[j]) {
					b[k++] = a[i++];
				} else {
					b[k++] = a[j++];
					c += mid - i;
				}
			}
			while (i <= (int) mid - 1)
				b[k++] = a[i++];
			while (j <= (int) right)
				b[k++] = a[j++];
			for (i = (int) left; i <= (int) right; i++)
				a[i] = b[i];
			return c;
		}  
		
	
		static class InputReader {
    		public BufferedReader reader;
    		public StringTokenizer tokenizer;
     
    		public InputReader(InputStream inputstream) {
    			reader = new BufferedReader(new InputStreamReader(inputstream));
    			tokenizer = null;
    		}
     
    		public String nextLine(){
    			String fullLine=null;
    			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    				try {
    					fullLine=reader.readLine();
    				} catch (IOException e) {
    					throw new RuntimeException(e);
    				}
    				return fullLine;
    			}
    			return fullLine;
    		}
    		public String next() {
    			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    				try {
    					tokenizer = new StringTokenizer(reader.readLine());
    				} catch (IOException e) {
    					throw new RuntimeException(e);
    				}
    			}
    			return tokenizer.nextToken();
    		}
    		public long nextLong() {
    			return Long.parseLong(next());
    		}
    		public int nextInt() {
    			return Integer.parseInt(next());
    		}
    	}
    	
    }