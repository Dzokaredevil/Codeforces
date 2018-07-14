import java.util.*;
import java.io.*;

public   class TestClass{
    static ArrayList<Integer>[] al;
         static class Pair implements Comparator<Pair>{
  int a;
  int b;
  Pair(){

  }
  Pair(int a,int b){
    this.a=a;
    this.b=b;
  }
  public int compare(Pair p1,Pair p2){

    return p1.a-p2.a;
 }
}
  
   static InputReader sc = new InputReader(); 
   static int gcd(int a,int b){
    if(a==0){
      return b;
    }
    return gcd(b%a,a);
   }
   static int d;
   static int[] color;
   static boolean[] v;
    static void dfs(int src,int x,int y){
      v[src]=true;
     int  i=1;
     color[src]=x;
      for(int a :al[src]){
        if(v[a]) continue;
        if(i==x|| i==y){
          i++;
          if(i==x|| i==y){
          i++;
        }
        }
        color[a]=i;
        i++;
         
      }
      for(int a:al[src]){
        if(!v[a]){
          dfs(a,color[a],x);
        }
      }




    }
    static long[] a;
    static long[] b;
    public static boolean possible(double mid,int n){
      double l=a[1]-b[1]*mid;
      double r=a[1]+b[1]*mid;
      for(int i=2;i<=n;i++){
        l=Math.max(l,a[i]-b[i]*mid);
        r=Math.min(r,a[i]+b[i]*mid);

      }
      if(l>r)return false;
      else  return true;
    }



    public static void main(String[] args) throws IOException{
          
           int n=i();
           int sum=0;
           while(n-->0){
              String s=s();
              switch(s){
                case "Tetrahedron":sum+=4;break;
                case "Cube":sum+=6;break;
                case "Octahedron":sum+=8;break;
                case "Dodecahedron":sum+=12;break;
                case "Icosahedron":sum+=20;break;


              }



           }
           System.out.println(sum);



           }
     

      static int i() {
           
          return sc.nextInt();
        }
        static long l() throws IOException{
          return sc.nextLong();

        }
        static double d() throws IOException{
          return sc.nextDouble();
        }
        static String s() throws IOException{
          return sc.next();

        }
        static String sL() throws IOException{
          return sc.nextLine();
        }
       static void loop(int[] a) throws IOException{
          for(int j=0;j<a.length;j++){
              a[j]=i();
          }
        }
        static void eloop(int[] a) throws IOException{
          for(int i=1;i<=a.length;i++){
              a[i]=i();
          }
        }
        static void ploop(int[] a)throws IOException{
             for(int j=0;j<a.length;j++){
                System.out.println(a[j]);
             }

        }
        static void eploop(int[] a)throws IOException{
             for(int j=1;j<=a.length;j++){
                System.out.println(a[j]);
             }

        } 
  
        ////////////////////////////////////////////////////////////////////////////////////////////////////
     

   

  static class InputReader {
        BufferedReader br;
        StringTokenizer st;
 
        public InputReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                throw new RuntimeException();
            }
            return str;
        }
    }

 }