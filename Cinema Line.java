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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int count25 = 0;
            int count50 = 0;
            boolean isAnswer = true;
            for(int i=0; i<n; i++){
                int value = in.nextInt();
                if(isAnswer==false){
                    continue;
                }
                if(value==25){
                    count25++;
                }else if(value==50){
                    if(count25!=0){
                        count25--;
                        count50++;
                    }else{
                        isAnswer=false;
                    }
                }else{
                    if(count50>=1 && count25>=1){
                        count50--;
                        count25--;
                    }else if(count25>=3){
                        count25-=3;
                    }else{
                        isAnswer=false;
                    }
                }
            }
            if(isAnswer==true){
                out.println("YES");
            }else{
                out.println("NO");
            }
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