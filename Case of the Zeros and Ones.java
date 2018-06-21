import java.io.IOException;
import static java.lang.System.in;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list; 
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 *
 * @author Dzok
 */
public class main {
public static boolean isPrime(long n) {
    if(n < 2) return false;
    if(n == 2 || n == 3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    long sqrtN = (long)Math.sqrt(n)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
    }
    return true;
}

static public class Princess{
 public int rate;public int beauty;public int intellect;public int richness;
 public Princess(int sum,int a,int b,int c){
  this.rate=sum;
  this.beauty=a;
  this.intellect=b;
  this.richness=c;
  }

        @Override
        public String toString() {
            return "Princess{" + "rate=" + rate + ", beauty=" + beauty + ", intellect=" + intellect + ", richness=" + richness + '}';
        }
 
 }
 public static boolean contains(final int[] arr, final int key) {
    return Arrays.stream(arr).anyMatch(i -> i == key);
 }
 static boolean isSubSequence(String str1, String str2, int m, int n)
    {
       
        if (m == 0) 
            return true;
        if (n == 0) 
            return false;
             
        
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return isSubSequence(str1, str2, m-1, n-1);
 
        
        return isSubSequence(str1, str2, m, n-1);
    }

    static int gcdThing(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}
    public static boolean checkAnagram(String str1, String str2) {
        int i=0;
        for (char c : str1.toCharArray()) {
        i = str2.indexOf(c, i) + 1;
        if (i <= 0) { return false; }
    }
    return true;

	}
   
   public static void main (String []  args) throws IOException 
    {
      Scanner s=new Scanner(System.in);long n=s.nextInt();
		String x=s.next();
		int countzeros=0;
		int countones=0;
		int talkwith=0;
        for (int i = 0; i < n; i++) {
            if(x.charAt(i)=='0'){countzeros++;}
            else{countones++;}
        }
        
        if(countones<=countzeros){talkwith=countones;}
        else{talkwith=countzeros;}
        System.out.print(x.length()-(talkwith*2));
	}  
}
