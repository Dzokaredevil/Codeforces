import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class EdA {

	private static long n;
	private static long m;

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		PrintWriter out = new PrintWriter(System.out);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int[] queries = new int[m];
		for (int i = 0; i < m; i++) {
			queries[i] = in.nextInt();
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			set.add(arr[i]);
			dp[i] = set.size();
		}
		for (int i = 0; i < m; i++) {
			out.println(dp[queries[i] - 1]);
		}
		out.close();
	}

	static boolean ana(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		return Arrays.equals(a1, a2);
	}

	static long numUnder(long ni) {
		long cnt = 0;
		for (int i = 1; i <= n; i++) {
			cnt += Math.min((ni - 1) / i, m);
		}
		return cnt;
	}

	// 20
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}