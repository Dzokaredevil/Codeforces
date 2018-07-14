import java.io.*;
import java.math.*; 
import java.util.*;

public class A439 {

    public static void main(String[] args) throws Exception{
        int data[] = IO.nextIntArray(2, " ");
        int songs[] = IO.nextIntArray(data[1], " ");
        int gaps = data[1]-1;
        int gapTime = gaps*10;
        int totalTime=gapTime;
        for(int i=1;i<songs.length;++i)totalTime+=songs[i]; 
        if(totalTime>data[2])IO.println(-1);
        else{
            int remaining = data[2]-totalTime;
            int jokes = remaining/5+(gapTime/5);
            IO.println(jokes);
        }
    }

 
    static class IO {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static int[][] next2dInt(int rows, int cols, String seperator) throws Exception {
            int[][] arr = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; ++i) {
                arr[i] = nextIntArray(cols, seperator);
            }
            return arr;
        }

        public static int[] nextIntArray(int nInts, String seperator) throws IOException {
            String ints = br.readLine();
            String[] sArray = ints.split(seperator);
            int[] array = new int[nInts + 1];
            for (int i = 1; i <= nInts; ++i) {
                array[i] = Integer.parseInt(sArray[i - 1]);
            }
            return array;
        }

        public static long[] nextLongArray(int nLongs, String seperator) throws IOException {
            String longs = br.readLine();
            String[] sArray = longs.split(seperator);
            long[] array = new long[nLongs + 1];
            for (int i = 1; i <= nLongs; ++i) {
                array[i] = Long.parseLong(sArray[i - 1]);
            }
            return array;
        }

        public static double[] nextDoubleArray(int nDoubles, String seperator) throws IOException {
            String doubles = br.readLine();
            String[] sArray = doubles.split(seperator);
            double[] array = new double[nDoubles + 1];
            for (int i = 1; i <= nDoubles; ++i) {
                array[i] = Double.parseDouble(sArray[i - 1]);
            }
            return array;
        }

        public static char[] nextCharArray(int nChars, String seperator) throws IOException {
            String chars = br.readLine();
            String[] sArray = chars.split(seperator);
            char[] array = new char[nChars + 1];
            for (int i = 1; i <= nChars; ++i) {
                array[i] = sArray[i - 1].charAt(0);
            }
            return array;
        }

        public static int nextInt() throws IOException {
            String in = br.readLine();
            return Integer.parseInt(in);
        }

        public static double nextDouble() throws IOException {
            String in = br.readLine();
            return Double.parseDouble(in);
        }

        public static long nextLong() throws IOException {
            String in = br.readLine();
            return Long.parseLong(in);
        }

        public static int nextChar() throws IOException {
            String in = br.readLine();
            return in.charAt(0);
        }

        public static String nextString() throws IOException {
            return br.readLine();
        }

        public static void print(Object... o) {
            for (Object os : o) {
                System.out.print(os);
            }
        }

        public static void println(Object... o) {
            for (Object os : o) {
                System.out.print(os);
            }
            System.out.print("\n");
        }

        public static void printlnSeperate(String seperator, Object... o) {
            StringBuilder sb = new StringBuilder();
            sb.delete(sb.length() - seperator.length(), sb.length());
            System.out.println(sb);
        }
    }
}  
