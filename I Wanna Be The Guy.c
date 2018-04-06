using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Runtime.CompilerServices;
namespace Rextester{
    public class Program{
     
        public static StreamWriter writer;
        private static Stream readStream;
        private static int idx, bufferSize, bytesRead;
        private static byte[] buffer;
        public const char Space = ' ';     // 32
        public const char MinusSign = '-'; // 45
        public const char Zero = '0';      // 48
        public const char HorizontalTab = '\t';  //  9
        public const char VerticalTab = '\v';    // 11
        public const char FormFeed = '\f';       // 12
        public const char CarriageReturn = '\r'; // 13
        public const char LineFeed = '\n';       // 10
   
        [MethodImpl(MethodImplOptions.AggressiveInlining)]    
        public static void Initialze(){
            readStream = Console.OpenStandardInput();   

            idx = bytesRead = 0;
            bufferSize = 1 << 14;
            buffer = new byte[bufferSize];
        }
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        private static void ReadConsoleInput(){
            idx = 0;
            bytesRead = readStream.Read(buffer, 0, bufferSize);
            if (bytesRead <= 0) buffer[0] = (byte)Space;
        }
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        public static byte ReadByte() {
            if (idx == bytesRead)         
                ReadConsoleInput();           
            return buffer[idx++];
        }
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        public static int ReadInt(){
            byte readByte;
            do{
                readByte = ReadByte();
            }
            while (readByte < MinusSign);

            bool negative = false;
            if (readByte == MinusSign){
                negative = true;
                readByte = ReadByte();
            }
            int m = readByte - Zero;
            while (true){
                readByte = ReadByte();
                if (readByte < Zero) break;
                m = m * 10 + (readByte - Zero);
            }
            if (negative) return -m;
            return m;
        }
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        public static StringBuilder ReadLine(){
            byte readByte;
            StringBuilder s = new StringBuilder();
            do{
                readByte = ReadByte();
            }
            while (readByte <= CarriageReturn);
            idx--;
            while (true){
                readByte = ReadByte();
                if (readByte <= CarriageReturn) break;
                s = s.Append((char)readByte);
            }
            return s;
        }
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        public static void Dispose(){
            readStream.Close();
            writer.Close();
        }             
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        public static void Main(string[] args){
			
            Initialze();
            writer = new StreamWriter(Console.OpenStandardOutput());         
            
            RealWork(); 
            Dispose();
        }
        [MethodImpl(MethodImplOptions.AggressiveInlining)]
        public static void RealWork()
        {
            int n = ReadInt();
            int[] level = new int[n+1];
            int x = ReadInt();
            int ans = 0;

            for (int i = 0; i < x; i++)
            {
                int temp = ReadInt();
                if (level[temp] == 0) {
                    level[temp]++;
                    ans++;                
                }            
            }
            int y = ReadInt();
            for (int i = 0; i < y; i++)
            {
                int temp = ReadInt();
                if (level[temp] == 0)
                {
                    level[temp]++;
                    ans++;
                }
            }
            writer.Write(ans == n ? "I become the guy." : "Oh, my keyboard!");

        }
    }
}