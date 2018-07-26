import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int test_cases = 1;
        Solver s = new Solver();
        for (int i = test_cases; i >= 1; i--)
            s.solve(1, in, out);
        out.close();
    }
    static class Solver {
        public void solve(int test_number, InputReader in, PrintWriter out) throws IOException {
            Scanner sc = new Scanner(System.in);
            char[] s = sc.next().toCharArray();
            ArrayList<Integer> v = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                char c = s[i];
                if (vowel(c)) {
                    v.add(i);
                }
            }
            int ans = Integer.MIN_VALUE;
            if (v.size() == 1) {
                ans = Math.max(Math.abs(v.get(0) - 0), Math.abs(v.get(0) - s.length));
            }
            if (v.size() == 0) ans = s.length + 1;
            for (int i = 0; i < v.size(); i++) {
                if (i == 0) {
                    ans = Math.max(ans, v.get(i) + 1 - 0);
                }
                else if (i == v.size() - 1) {
                    ans = Math.max(ans, v.get(i) - v.get(i - 1));
                    ans = Math.max(ans, s.length - v.get(i));
                }
                else {
                    ans = Math.max(ans, v.get(i) - v.get(i - 1));
                }
            }
            out.println(ans);
        }

        private boolean vowel(char c) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y') return true;
            return false;
        }
    }
    static class InputReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public InputReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public InputReader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }



        public String next() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == ' ' || c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String nextLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
