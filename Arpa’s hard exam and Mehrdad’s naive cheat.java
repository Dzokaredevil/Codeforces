import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
 
public class SarthakCode 
{
	static InputReader sc = new InputReader(System.in);
    static OutputWriter pw = new OutputWriter(System.out);
    
	public static void main(String args[])throws Exception
	{	
		int n=sc.nextInt(); 
		pw.println(func(1378,n));
		pw.close();
	}
	public static int func(int a, int b) 
	{
		 
	    if(b==0)return 1;
	    int da = a % 10;
	 
	    if(da==0)return 0;
	    if(da==5)return 5; 
	    switch(b%4){
	    case 0:
	      return da%2!=0?1:6;
	    case 1:
	      return da;
	    case 2:
	      return da*da%10;
	    default:
	      return da*da*da%10;
	    }
	}
}
 





 
//Input And Output
 
class InputReader 
{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;
 
    public InputReader(InputStream stream){
        this.stream = stream;
    }
    
    public int read() {
        if (numChars == -1){
            throw new InputMismatchException();
        }
        if (curChar >= numChars){
            curChar = 0;
            try {numChars = stream.read(buf);} 
            catch (IOException e){throw new InputMismatchException();}
            if (numChars <= 0){
                return -1;}
        }
        return buf[curChar++];
    }
    
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();}
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read(); }
        int res = 0;
        do{
            if (c < '0' || c > '9'){throw new InputMismatchException();}
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    
    public long nextLong(){
		long num = 0;
		int b;
		boolean minus = false;
		while((b = read()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = read();
		}
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}
			else { return minus ? -num : num; }
			b = read();}
	}
    
    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
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
    
    public double nextDouble(){
        int c = read();
        while (isSpaceChar(c)){
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.'){
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.'){
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
    
    private boolean isSpaceChar(int c){
        if (filter != null) {
            return filter.isSpaceChar(c);}
        return isWhitespace(c);
    }
 
    private static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    
    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
    
    public interface SpaceCharFilter{
        public boolean isSpaceChar(int ch);
    } 
    
}
class OutputWriter 
{
    private final PrintWriter writer;
    
    public OutputWriter(OutputStream outputStream){
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
 
    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }
 
    public void print(Object... objects){
        for (int i = 0; i < objects.length; i++){
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    } 
    
    public void println(Object... objects){
        print(objects);
        writer.println();
    }
    public void close() {
        writer.close();
    }
}  
