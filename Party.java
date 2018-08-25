import java.io.*;
import java.util.*;

import javax.swing.text.html.MinimalHTMLWriter;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min; 


public class Main {


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
        void madAdd(Map <Integer, Integer> map, int value){
            if(map.containsKey(value)){
                map.put(value, map.get(value)+1);
            }else{
                map.put(value, 1);
            }
        }
        //I have to try at least two ways to solve this problem, I'll make one of them ;
        class Pair implements Comparable<Pair>{
            int fist;
            int second;
            Pair(int fist, int second){
                this.fist = fist;
                this.second = second;
            }
            @Override
            public int compareTo(Pair arg0) {
                if(arg0.fist!=arg0.second){
                    return fist-arg0.fist;
                }else{
                    return arg0.second-second;
                }
            }
        }

        List<Integer> topologicalSort = new ArrayList<>(1000);
        byte g[][];
        boolean []isVisited;
        int deap;
        int maxDeap;
        void dfs(int v){
            deap++;
            maxDeap = max(maxDeap, deap);
            isVisited[v]=true;
            for(int i=1; i<isVisited.length; i++){
                if(isVisited[i]!=true && g[v][i]==1){
                    dfs(i);
                    deap--;
                }
            }
        }
        void dfs1(int v){
            isVisited[v]=true;
            for(int i=0; i<isVisited.length; i++){
                if(g[v][i]!=0 && isVisited[i]==false){
                    dfs1(i);
                }
            }
            topologicalSort.add(v);
        }
        void topologicalSort1(){
            for(int i=1; i<isVisited.length; i++){
                if(isVisited[i]==false){
                    dfs1(i);
                }
            }
            Collections.reverse(topologicalSort);
        }


        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            g = new byte[n+1][n+1];
            isVisited = new boolean[n+1];
            for(int i=1; i<=n; i++){
                int to = in.nextInt();
                if(to!=-1){
                    //g[i][to]=1;
                    g[to][i]=1;
                }
            }
            topologicalSort1();
            for(int i=1; i<=n; i++){
                isVisited[i]=false;
            }
            for(int i=1; i<=n; i++){
                int v = topologicalSort.get(i-1);
                deap = 0;
                if(isVisited[v]==false) {
                    dfs(v);
                }
            }
            out.println(maxDeap);
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
        public int nextInt()  {return Integer.parseInt(next());}
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
                write.write("something for cheaking");
                write.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void writeFile1(){
            try{
                FileWriter write = new FileWriter(file);
                write.append("100000"+" ");
                for(int i=0; i<100000; i++){
                    write.append(new Integer((int)(Math.random()*5000)).toString()+" ");
                }
                write.close();

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
