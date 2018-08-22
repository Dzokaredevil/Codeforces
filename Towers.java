import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.random;
import static java.lang.Math.*;



public class TriangleEasy {
    public static void main(String [] args){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Integer readFromFile=new Integer(1);
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskD {
        final int MAX =1001;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int []bult = new int[MAX];
            for(int i=0; i<n; i++){
                bult[in.nextInt()]++;
            }
            int maxHeight = 0;
            int countTower = 0;
            for(int i=0; i<MAX; i++){
                if(bult[i]!=0){
                    countTower++;
                    maxHeight = max(maxHeight, bult[i]);
                }
            }
            out.println(maxHeight+" "+countTower);
        }
    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        String st1;
        File file = new File("text.txt");
        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }
        public InputReader(int i) {
            try {
                br  = new BufferedReader(
                        new InputStreamReader(new FileInputStream(file)));
            } catch (FileNotFoundException e1) {
                System.out.println("File is not find");
            }
            st = null;
        }
        public String next(){
            while (st==null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        public String nextLine(){
            try {
                st1 = new String(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return st1;
        }
        public int nextInt()  {
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public Double nextDouble(){
            return Double.parseDouble(next());
        }
        public Byte nextByte() {
            return Byte.parseByte(next());
        }
        private int idx;
        public Character nextChar() {
            if(st1==null) {
                st1 = next();
                idx = 0;
            }
            if(idx!=(st1.length())-1){
                return st1.charAt(idx++);
            }else{
                char  c= st1.charAt(idx);
                st1 = null;
                return c;
            }
        }
        public void newFile() {
            try {
                FileWriter write = new FileWriter(file);
                write.write(1);
                write.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}