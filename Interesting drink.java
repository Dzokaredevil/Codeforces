import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Astone {
	//static int flag=1
	static int count=0;
	private static InputStream stream;
	private static byte[] buf=new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	private static PrintWriter pw;
    public static void main(String args[] ) throws Exception 
    {
    	InputReader(System.in);
		pw=new PrintWriter(System.out);
		soln();
		pw.close();
    }
    public static void soln()
    {
    	//int t=nextInt();
    	int n=nextInt();
    	int a[]=nextIntArray(n);
    	Merge_Sort(a);
    	int q=nextInt();
    	int count=0;
    	for(int i=0;i<n-1;i++)
    	{
    		if(a[i]==a[i+1])
    			count++;
    	}
    	//System.out.println(count);
    	int max=-1;
    	if(count==n-1)
    	{
    		max=a[0];
    	}
    	//System.out.println(max);
    	
    	for(int i=0;i<q;i++)
    	{
    		int num=nextInt();
    		if(num==max)
    		{
    			System.out.println(n);
    		}
    		else {
    		int x=BinarySearch(num,a);
    		
    		if(x!=-1)
    		System.out.println(x);
    		else
    			System.out.println("0");
    		}
    	}
    }
  
    static int BinarySearch(int target, int nums[]) {
        /// return index of first one that comp(item,target)==true, or nums.size() if not found
		/// comp is greater or equal to for lower_bound
		/// comp is greater for upper_bound
        int first=0, last=nums.length, mid;
        while (first<last) {
            mid=first+((last-first)>>1); // first<=mid, mid<last
			/// if comp(item,target)==false, advance first
			// if(nums[mid]<=target) // for upper_bound
			if (nums[mid]<=target) // for lower_bound
				first=mid+1; // first always increases
			else /// else recede last
				last=mid; // last always decreases (even last-first==1)
        }
        return first;
    }

private static void Merge_Sort(int[] a) {
		int n=a.length;
		if(n<2)
			return;
		int mid=n/2;
		//System.out.println(mid);
		int[] left=new int[mid];
		int[] right=new int[n-mid];
		for(int i=0;i<mid;i++)
			left[i]=a[i];
		for(int j=mid;j<n;j++)
			right[j-mid]=a[j];
		Merge_Sort(left);
		Merge_Sort(right);
		a=Merge(left,right,a);
	}
// To Get Input
 	// Some Buffer Methods
 
	
	private static int[] Merge(int[] left, int[] right, int[] a) {
	int nl=left.length;
	int nr=right.length;
	int i=0;
	int j=0;
	int k=0;
	
	while(i<nl && j<nr)
	{
	
		if(left[i]<=right[j])
		{
			a[k++]=left[i++];
		}
		else
			a[k++]=right[j++];
	}
	while(i<nl)
		a[k++]=left[i++];
	while(j<nr)
		a[k++]=right[j++];
	return a;
}

	public static void InputReader(InputStream stream1) {
 		stream = stream1;
 	}
 
 	private static boolean isWhitespace(int c) {
 		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
 	}
 
 	private static boolean isEndOfLine(int c) {
 		return c == '\n' || c == '\r' || c == -1;
 	}
 
 	private static int read() {
 		if (numChars == -1)
 			throw new InputMismatchException();
 		if (curChar >= numChars) {
 			curChar = 0;
 			try {
 				numChars = stream.read(buf);
 			} catch (IOException e) {
 				throw new InputMismatchException();
 			}
 			if (numChars <= 0)
 				return -1;
 		}
 		return buf[curChar++];
 	}
 
 	private static int nextInt() {
 		int c = read();
 		while (isSpaceChar(c))
 			c = read();
 		int sgn = 1;
 		if (c == '-') {
 			sgn = -1;
 			c = read();
 		}
 		int res = 0;
 		do {
 			if (c < '0' || c > '9')
 				throw new InputMismatchException();
 			res *= 10;
 			res += c - '0';
 			c = read();
 		} while (!isSpaceChar(c));
 		return res * sgn;
 	}
  
 	private static long nextLong() {
 		int c = read();
 		while (isSpaceChar(c))
 			c = read();
 		int sgn = 1;
 		if (c == '-') {
 			sgn = -1;
 			c = read();
 		}
 		long res = 0;
 		do {
 			if (c < '0' || c > '9')
 				throw new InputMismatchException();
 			res *= 10;
 			res += c - '0';
 			c = read();
 		} while (!isSpaceChar(c));
 		return res * sgn;
 	}
  
 	private static String nextToken() {
 		int c = read();
 		while (isSpaceChar(c))
 			c = read();
 		StringBuilder res = new StringBuilder();
 		do {
 			res.appendCodePoint(c);
 			c = read();
 		} while (!isSpaceChar(c));
 		return res.toString();
 	}
  
 	private static String nextLine() {
 		int c = read();
 		while (isSpaceChar(c))
 			c = read();
 		StringBuilder res = new StringBuilder();
 		do {
 			res.appendCodePoint(c);
 			c = read();
 		} while (!isEndOfLine(c));
 		return res.toString();
 	}
 
 	private static int[] nextIntArray(int n) {
 		int[] arr = new int[n];
 		for (int i = 0; i < n; i++) {
 			arr[i] = nextInt();
 		}
 		return arr;
 	}
 	  
 	private static long[] nextLongArray(int n) {
 		long[] arr = new long[n];
 		for (int i = 0; i < n; i++) {
 			arr[i] = nextLong();
 		}
 		return arr;
 	}
 
 	private static void pArray(int[] arr){
 		for (int i=0; i<arr.length; i++) {
 			System.out.print(arr[i] + " ");
 		}
 		System.out.println();
 		return;
 	}
 
 	private static void pArray(long[] arr){
 		for (int i=0; i<arr.length; i++) {
 			System.out.print(arr[i] + " ");
 		}
 		System.out.println();
 		return;		
 	}
 
 	private static boolean isSpaceChar(int c) {
 		if (filter != null)
 			return filter.isSpaceChar(c);
 		return isWhitespace(c);
 	}
  
 	private interface SpaceCharFilter {
 		public boolean isSpaceChar(int ch);
 	}
}