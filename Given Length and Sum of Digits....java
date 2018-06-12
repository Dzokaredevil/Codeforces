import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C489 {
	static StringBuilder[][] memo;
	static int N;
	static int total;
	static final BigInteger INF = new BigInteger("" + ((int) 1e9));
	static final BigInteger negINF = INF.multiply(new BigInteger("-1"));

	public static StringBuilder dp(int sum, int len, StringBuilder seq) {
		if (len == N)
			if (sum == total) {
				// System.out.println(seq);
				return seq;
			} else
				return new StringBuilder("");
		StringBuilder sb = new StringBuilder();
		if (memo[sum][len] != null)
			return memo[sum][len];
		StringBuilder max = new StringBuilder();
		String s = seq.toString();
		for (int i = 9; i >= 0; i--) {

			StringBuilder cur = dp(sum + i, len + 1, new StringBuilder("").append(s + i));

			if ((cur.toString()).compareTo(max.toString()) > 0)
				max = cur;
		}
		return memo[sum][len] = max;

	}

	public static StringBuilder dp2(int sum, int len, StringBuilder seq) {
		if (len == N)
			if (sum == total) {
				// System.out.println(seq);
				return seq;
			} else
				return new StringBuilder("");
		StringBuilder sb = new StringBuilder();
		if (memo[sum][len] != null)
			return memo[sum][len];
		int start = 0;
		if(len==0)
			start++;
		StringBuilder max = new StringBuilder( 
				"9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
		String s = seq.toString();
		for (int i = start; i <=9; i++) {
//			System.out.println(max);
			StringBuilder cur = dp2(sum + i, len + 1, new StringBuilder("").append(s + i));
//			System.out.println((cur.toString()).equals(""));
			if ((cur.toString()).compareTo(max.toString()) < 0 && !(cur.toString()).equals(""))
				max = cur;
		}
		return memo[sum][len] = max;

	}

	// public static BigInteger dpMin(int sum, int len,BigInteger seq){
	//// System.out.println("hi");
	// if(len==N)
	// if(sum==total){
	// System.out.println(seq);
	// return seq;
	// }
	// else
	// return INF;
	// if(!memo[sum][len].equals(new BigInteger("-1")))
	// return memo[sum][len];
	// BigInteger min = INF;
	// for (int i = 0; i<9; i++) {
	// BigInteger cur = dp(sum+i,len+1,new BigInteger(seq.toString()+""+i));
	//
	// if(cur.compareTo(min)<0)
	// min = cur;
	// }
	// return memo[sum][len] =min;
	//
	// }
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		total = sc.nextInt();
		memo = new StringBuilder[901][101];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], null);
		}

		// System.out.println(dp(0,0,0));

		StringBuilder max = dp(0, 0, new StringBuilder());

		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], null);
		}

		StringBuilder min = dp2(0, 0, new StringBuilder());
		// for (int i = 0; i < memo.length; i++) {
		// Arrays.fill(memo[i], new BigInteger("-1"));
		// }

		// BigInteger min = dpMin(0, 0, BigInteger.ZERO);
		// for (int i = 0; i < memo.length; i++) {
		// for (int j = 0; j < memo[i].length; j++) {
		//// max = Math.max(max, memo[i][j]);
		// if(min.compareTo(memo[i][j])>0)
		// min = memo[i][j];
		// }
		// }
		// String min = "";
		// if(max.equals(BigInteger.ZERO)){
		// min = "-1"; max = new BigInteger("-1");
		// }
		// else
		// min=new StringBuilder(""+max).reverse().toString();
		//
		// String mx = ""+max;

		// if(max!=-1)
		// for (int i = (""+max).length()-1; i>=0; i--) {
		// min+=mx.charAt(i);
		// }
		// else
		// min = "-1";

		// System.out.println(dp(0,0,0));
//		int count2 = 0;String res2 = max.reverse().toString();
//		String res = "";int count = 0;
//		for (int i = 0; i < min.length(); i++) {
//			if(min.charAt(i)=='0')
//				count++;
//			else
//				res+=min.charAt(i);
//			
//		}
//		String rinalRes2 = "";
//		for (int i = 0; i < res2.length(); i++) {
//			if(res2.charAt(i)=='0') count2++;
//			else
//				rinalRes2+=res2.charAt(i);
//		}
//		for (int i = 0; i < count2; i++) {
//			rinalRes2+=0;
//		}
//		for (int i = 0; i < count; i++) {
//			res+="0";
//		}
//		String mn = min.toString();
		
//		System.out.println(res2);
//		String fs = (res.charAt(0)-'0')>(rinalRes2.charAt(0)-'0')?(rinalRes2):res;
//		System.out.println(fs);
		if (N == 1 && total == 0) {
		    System.out.println("0 0");
		    
		}else
			if(min.toString().replace("0", "").length()!=0 && max.toString().replace("0","").length()!=0)
		System.out.println(min + " " + max);
			else
				System.out.println("-1 -1");

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
