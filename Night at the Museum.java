import java.io.*;
import java.util.*;

// this is not good for reading double values.

public class Round731A {
	static long m = 100000007;
	static Reader r;
	static PrintWriter o;

	public static void main(String[] args) throws IOException {
		r = new Reader();
		o = new PrintWriter(System.out, false);
		String s = r.readString();
		int x = (s.charAt(0) - 'a') - 0;
		x = Math.min(x, 26-x);
		int index = s.charAt(0) - 'a';
		for (int i = 1; i < s.length(); i++) {
			int y = Math.abs((s.charAt(i) - 'a') - index);
			x += Math.min(y, 26 - y);
			index = s.charAt(i) - 'a';
		}
		o.println(x);
		o.close();
	}

	// pair object x,y
	static class pair {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			pair other = (pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		int x, y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	public static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	static long[][] modPow(long[][] M, long exp) {
		long[][] result = new long[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		long[][] pow = M;
		while (exp != 0) {
			if ((exp & 1) == 1) {
				result = multiply(result, pow);
			}
			exp >>>= 1;
			pow = multiply(pow, pow);
		}
		return result;
	}

	static long[][] multiply(long[][] A, long[][] B) {
		long[][] C = new long[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				long value = 0;
				for (int k = 0; k < 4; k++) {
					value += A[i][k] * B[k][j];
				}
				C[i][j] = value % m;
			}
		}
		return C;
	}

	// input/output
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}

		public int[] readIntArray(int size) throws IOException {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++)
				arr[i] = nextInt();
			return arr;
		}

		public long[] readLongArray(int size) throws IOException {
			long[] arr = new long[size];
			for (int i = 0; i < size; i++)
				arr[i] = nextLong();
			return arr;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}