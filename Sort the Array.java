import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream; 
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class _551B {
    InputStream is;
    PrintWriter out;
    String INPUT = "4\n" +
            "2 1 3 4";

    void solve() {
        int n = ni();
        int[] a = na(n);
        if(n == 1){
            out.println("yes");
            out.println(1 + " " + 1);
            return;
        }
        int left = -1;
        for(int i = 0;i+1 < n;i++){
            if(a[i] > a[i+1]){
                left = i;
                break;
            }
        }
        int right = -1;
        for(int i = n-1;i-1 >= 0;i--){
            if(a[i] < a[i-1]){
                right = i;
                break;
            }
        }
        if(left == -1){
            out.println("yes");
            out.println(1 + " " + 1);
            return;
        }
        if(left-1 >= 0 && a[left-1] > a[right]){
            out.println("no");
            return;
        }
        if(right+1 < n && a[left] > a[right+1]){
            out.println("no");
            return;
        }
        for(int i = left;i+1 <= right;i++){
            if(a[i] > a[i+1]){
            }else{
                out.println("no");
                return;
            }
        }
        out.println("yes");
        out.println((left+1) + " " + (right+1));
    }

    /* TEMPLATED CODE BELOW */
    void run() throws Exception {
        is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new _551B().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    // prints 2d array
    private void printa(int[][] a) {
        out.printf("\t");
        for (int i = 0; i < a[0].length; i++) out.printf("%5d ", i);
        out.println();
        out.println("----------------");
        for (int i = 0; i < a.length; i++) {
            out.printf(i + " =>");
            for (int j = 0; j < a[i].length; j++) {
                out.printf("%5d ", a[i][j]);
            }
            out.println();
        }
        out.println();
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (!oj) System.out.println(Arrays.deepToString(o));
    }

}
