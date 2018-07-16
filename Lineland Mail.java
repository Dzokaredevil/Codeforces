import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class main{
    
    public static void main(String args[])throws IOException{
      Reader in=new Reader();
      int cities=in.nextInt();
      int max,min;
      int dis[]=new int[cities];
      for(int i=0;i<cities;++i)
          dis[i]=in.nextInt();
      for(int i=0;i<cities;++i){
          if(i==0){
            min=dis[i+1]-dis[i];
            max=dis[cities-1]-dis[i];
          }
          else
             if(i==cities-1){
                 min=dis[i]-dis[i-1];
                 max=dis[i]-dis[0];
             }
             else{
                 min=Math.min(Math.abs(dis[i]-dis[i+1]), Math.abs(dis[i]-dis[i-1]));
                 max=Math.max(Math.abs(dis[i]-dis[0]),Math.abs(dis[i]-dis[cities-1]));
             }
          System.out.println(min);
          System.out.println(max);
      }
      
      
    }
   
   
}




class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }/*public boolean isSpace(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }public String next() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(isSpace(c))break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
            }*/

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10L + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.')
                while ((c = read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) <= ' ')
                ;
            do {
                sb.append((char) c);
            } while ((c = read()) > ' ');
            return sb.toString();
        }

        public int nextInt2() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }