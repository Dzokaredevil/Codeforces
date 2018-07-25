import java.util.*;

import java.io.*;

public class temppp {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		FastInputReader s = new FastInputReader();
		
		 int n = s.nextInt();
	     long[] arr = new long[n];
	     long sum = 0;
	     for(int i=0;i<n;i++) {
	    	 arr[i] = s.nextLong();
	    	 sum+=arr[i];
	     }
	     if(sum%3!=0) {
	    	 System.out.println(0);
	    	 return;
	     }
	      sum=sum/3;
	     long[] freq = new long[n];
	      long ss = 0;
	      int k=0;
	     for(int i=n-1;i>=0;i--) {
	    	 ss+=arr[i];
	    	 if(sum==ss) {
	    		 k++;
	    		 freq[i]=k;
	    	 }else {
	    		 freq[i]=k;
	    	 }
	     }
	     long count = 0;
	     ss = 0;
	     for(int i=0;i<n-2;i++) {
	    	 ss+= arr[i];
	    	 if(ss==sum) {
	    		 count+=freq[i+2];
	    	 }
	     }
		 System.out.println(count);
		
	}

	public static class FastInputReader {

		private byte[] buf = new byte[16384];

		private int curChar;

		private int numChars;

		public int read() {

			if (numChars == -1)

				throw new InputMismatchException();

			if (curChar >= numChars) {

				curChar = 0;

				try {

					numChars = System.in.read(buf);

				} catch (IOException e) {

					throw new InputMismatchException();

				}

				if (numChars <= 0)

					return -1;

			}

			return buf[curChar++];

		}

		public String nextLine() {

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

		public String nextString() {

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

		public long nextLong() {

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

		public int nextInt() {

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

		public int[] nextIntArray(int n) {

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {

				arr[i] = nextInt();

			}

			return arr;

		}

		public long[] nextLongArray(int n) {

			long[] arr = new long[n];

			for (int i = 0; i < n; i++) {

				arr[i] = nextLong();

			}

			return arr;

		}

		private boolean isSpaceChar(int c) {

			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;

		}

		private boolean isEndOfLine(int c) {

			return c == '\n' || c == '\r' || c == -1;

		}

	}

	public static class MyScanner {

		BufferedReader reader;

		public MyScanner() {

			this.reader = new BufferedReader(new InputStreamReader(System.in));

		}

		public void close() throws IOException {

			this.reader.close();

		}

		int nextInt() {

			return Integer.parseInt(this.next());

		}

		long nextLong() {

			return Long.parseLong(this.next());

		}

		float nextFloat() {

			return Float.parseFloat(this.next());

		}

		double nextDouble() {

			return Double.parseDouble(this.next());

		}

		String next() {

			String str = "";

			try {

				str = this.reader.readLine().trim();

			} catch (IOException e) {

				e.printStackTrace();

			}

			return str;

		}

		String[] nextStringArray() {

			String[] str = null;

			try {

				str = this.reader.readLine().trim().split(" ");

			} catch (IOException e) {

				e.printStackTrace();

			}

			return str;

		}

		int[] nextIntArray() {

			String[] data = nextStringArray();

			int[] a = new int[data.length];

			for (int i = 0; i < a.length; i++) {

				a[i] = Integer.parseInt(data[i]);

			}

			return a;

		}

		Integer[] nextIntegerArray() {

			String[] data = nextStringArray();

			Integer[] a = new Integer[data.length];

			for (int i = 0; i < a.length; i++) {

				a[i] = Integer.parseInt(data[i]);

			}

			return a;

		}

		long[] nextLongArray() {

			String[] data = nextStringArray();

			long[] a = new long[data.length];

			for (int i = 0; i < a.length; i++) {

				a[i] = Long.parseLong(data[i]);

			}

			return a;

		}

		float[] nextFloatArray() {

			String[] data = nextStringArray();

			float[] a = new float[data.length];

			for (int i = 0; i < a.length; i++) {

				a[i] = Float.parseFloat(data[i]);

			}

			return a;

		}

		double[] nextDoubleArray() {

			String[] data = nextStringArray();

			double[] a = new double[data.length];

			for (int i = 0; i < a.length; i++) {

				a[i] = Double.parseDouble(data[i]);

			}

			return a;

		}

	}

}
