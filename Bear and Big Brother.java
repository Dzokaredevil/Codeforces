import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1{
	public static void main(String[] args) throws IOException{
		FastReader sc = new FastReader();
		int a = sc.nextInt();
		int b= sc.nextInt();
		for(int i = 1;;i++){
			if(3 * a > 2 * b){
				System.out.println(i);
				break;
			}else{
				a = 3 * a;
				b = 2 * b;
			}
		}
	}
	public static String fmt(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}
	public static int[][] comparator(int[][] arr){
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b) {
                Integer a1 = a[0];
                Integer b1 = b[0];
            	return a1.compareTo(b1);
            }
        });
		return arr;
	}
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
	public static String min(int m,int n){
		int[] arr = new int[m];
		arr[0] = 1;
		int sum = 1;
		int j = m - 1;
		for(int i = 1;i <= 18* m + 10;i++){
			if(sum != n){
				if(arr[j] == 9){
					j--;
				}else{
					arr[j]++;
					sum++;
				}
			}
			else{
				break;
			}
		}
		StringBuilder min = new StringBuilder("");
		for(int i = 0;i < arr.length;i++){
			min.append(arr[i]);
		}
		return min.toString();
	}
	public static String max(int m,int n){
		int[] arr = new int[m];
		arr[0] = 1;
		int sum = 1;
		int j = 0;
		for(int i = 1;i <= 9 * m + 10;i++){
			if(sum != n){
				if(arr[j] == 9){
					j++;
				}else{
					arr[j]++;
					sum++;
				}
			}
			else{
				break;
			}
		}
		StringBuilder min = new StringBuilder("");
		for(int i = 0;i < arr.length;i++){
			min.append(arr[i]);
		}
		return min.toString();
	}
    public static int KMPSearch(String txt,String pat){
		int m = pat.length();
		int n = txt.length();
		int lps[] = new int[m];
		int j = 0;
		int count = 0;
		PrefixTable(pat,m,lps);
		int i = 0;
		while (i < n)
	        {
	            if (pat.charAt(j) == txt.charAt(i))
	            {
	                j++;
	                i++;
	            }
	            if (j == m)
	            {
	            	count++;
	                j = lps[j-1];
	            }
	            else if (i < n && pat.charAt(j) != txt.charAt(i))
	            {
	                if (j != 0)
	                    j = lps[j-1];
	                else
	                    i = i+1;
	            }
	        }
		return count;
	}
	public static void PrefixTable(String pat,int m,int[] lps){
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while(i < m){
			if(pat.charAt(i) == pat.charAt(len)){
				lps[i] = len + 1;
				i++;
				len++;
			}else if(len > 0){
				len = lps[len - 1];
			}else{
				lps[i] = 0;
				i++;
			}
		}
	}
    public int digit(int x){
    	int temp = x;
    	int count = 0;
    	while(temp != 0){
    		count++;
    		temp = temp/10;
    	}
    	return count;
    }
    public int sum(int x){
    	int temp = x;
    	int count = 0;
    	while(temp != 0){
    		count += temp % 10;
    		temp = temp/10;
    	}
    	return count;
    }
    public int product(int x){
    	int temp = x;
    	int count = 1;
    	while(temp != 0){
    		count*=temp % 10;
    		temp = temp/10;
    	}
    	return count;
    }
    public boolean isValid2(int x){
    	int temp = x;
    	while(temp != 0){
    		if(temp % 10 == 0){
    			return false;
    		}
    		temp = temp/10;
    	}
    	return true;
    }
    public boolean isValid(int x){
    	if(!isValid2(x)){
    		return false;
    	}else{
    		if(product(x) <= sum(x)){
    			return true;
    		}
    		return false;
    	}
    }
}