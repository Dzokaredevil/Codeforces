import java.io.*;
import java.util.*; 
import java.lang.Math;
public class Main {
        String INPUT = "4 1 2 3 -4";
        char[][] a;
        void solve()
        {
                String s = s();
                if(check(s)) {
                        //BC23 form
                        out.println(solve1(s));
                }else{
                        out.println(solve2(s));
                }
        }
        String solve1(String s){
                int ind = 0;
                while(s.charAt(ind)>='A' && s.charAt(ind)<='Z') ind++;
                return "R"+s.substring(ind)+"C"+getID(s.substring(0,ind));
        }
        String solve2(String s){
                int ind = 1;
                while(s.charAt(ind)>='0'&&s.charAt(ind)<='9') ind++;
                return getStr(toNUm(s.substring(ind+1)))+s.substring(1,ind);
        }
        int toNUm(String s){
                int x = 0;
                for (int i = 0; i < s.length(); i++) {
                        x = 10*x+(int)(s.charAt(i)-'0');
                }
                return x;
        }
        String getStr(int s){
                s--;
                int len = 1;
                int z = 26;
                while(s>=z){
                        s-=z;
                        z*=26;
                        len++;
                }
                StringBuilder a = new StringBuilder("");
                for (int i = 0; i < len; i++) {
                        a.append('A');
                }
                for (int i = 0; i < len; i++) {
                        z/=26;
                        while(s>=z){
                                s-=z;
                                a.setCharAt(i,(char)(a.charAt(i)-'A'+1+65));
                        }
                }
                return a.toString();
        }
        String getID(String s){
                int z = 1;
                int res = 0;
                for(int i = s.length()-1;i>=0; i--){
                        res+=(s.charAt(i)-'A'+1)*z;
                        z*=26;
                }
                return String.valueOf(res);
        }
        boolean check(String s){
                int ind = 0;
                while(s.charAt(ind)>='A' && s.charAt(ind)<='Z') ind++;//parse all the alphabet characters
                for (int i = ind; i < s.length(); i++) {
                        if(s.charAt(i)>='A' && s.charAt(i)<='Z')//checks whether any other alphabetic character are pres
                                return false;
                }
                return  true;
        }
        void run() throws Exception{
                is = System.in;
                out = new PrintWriter(System.out);
                int t = i();
                while(t-->0)
                solve();
                out.flush();
        }
        public static void main(String[] args)throws Exception {
                new Main().run();
        }
        InputStream is;
        PrintWriter out;
        private byte[] inbuf = new byte[1024];
        public int lenbuf = 0, ptrbuf = 0;

        private int readByte()
        {
                if(lenbuf == -1)throw new InputMismatchException();
                if(ptrbuf >= lenbuf){
                        ptrbuf = 0;
                        try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                        if(lenbuf <= 0)return -1;
                }
                return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
        private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

        private double d() { return Double.parseDouble(s()); }
        private char c() { return (char)skip(); }

        private String s()
        {
                int b = skip();
                StringBuilder sb = new StringBuilder();
                while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
                        sb.appendCodePoint(b);
                        b = readByte();
                }
                return sb.toString();
        }

        private char[] sa(int n)
        {
                char[] buf = new char[n];
                int b = skip(), p = 0;
                while(p < n && !(isSpaceChar(b))){
                        buf[p++] = (char)b;
                        b = readByte();
                }
                return n == p ? buf : Arrays.copyOf(buf, p);
        }

        private char[][] nm(int n, int m)
        {
                char[][] map = new char[n][];
                for(int i = 0;i < n;i++)map[i] = sa(m);
                return map;
        }

        private int[] ia(int n)
        {
                int[] a = new int[n];
                for(int i = 0;i < n;i++)a[i] = i();
                return a;
        }

        private int i()
        {
                int num = 0, b;
                boolean minus = false;
                while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
                if(b == '-'){
                        minus = true;
                        b = readByte();
                }

                while(true){
                        if(b >= '0' && b <= '9'){
                                num = num * 10 + (b - '0');
                        }else{
                                return minus ? -num : num;
                        }
                        b = readByte();
                }
        }

        private long l()
        {
                long num = 0;
                int b;
                boolean minus = false;
                while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
                if(b == '-'){
                        minus = true;
                        b = readByte();
                }

                while(true){
                        if(b >= '0' && b <= '9'){
                                num = num * 10 + (b - '0');
                        }else{
                                return minus ? -num : num;
                        }
                        b = readByte();
                }
        }


}
