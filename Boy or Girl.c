using System;
using System.Collections.Generic;
namespace Olymp
{
    public class Program
    {
        static void Z1A ()
        {
            uint n, m, a;
            string str = Console.ReadLine ();
            string [] strs = str.Split (' ');
            n = UInt32.Parse (strs [0]);
            m = UInt32.Parse (strs [1]);
            a = UInt32.Parse (strs [2]);


            uint nn = n / a;
            if (n % a > 0)
                nn++;
            uint nm = m / a;
            if (m % a > 0)
                nm++;
            ulong result = (ulong)nn * (ulong)nm;
            Console.WriteLine (result);
        }

        static void Z4A ()
        {
            int w = Int32.Parse (Console.ReadLine ());
            if (w % 2 == 0 && w > 2)
                Console.WriteLine ("YES");
            else
                Console.WriteLine ("NO");
        }

        static void Z158A ()
        {
            int n, k;
            string [] strs = Console.ReadLine ().Split (' ');
            n = Int32.Parse (strs [0]);
            k = Int32.Parse (strs [1]);
            strs = Console.ReadLine ().Split (' ');
            int max = 0;
            int i;
            for (i = 0; i < k; i++) {
                max = Int32.Parse (strs [i]);
                if (max == 0) {
                    Console.WriteLine (i);
                    return;
                }
            }
            int sum = k;
            for (; i < n; i++) {
                if (Int32.Parse (strs [i]) < max)
                    break;
                sum++;
            }
            Console.WriteLine (sum);
        }

        static void Z71A ()
        {
            int n = Int32.Parse (Console.ReadLine ());
            string str;
            for (int i = 0; i < n; i++) {
                str = Console.ReadLine ();
                if (str.Length > 10) {
                    Console.WriteLine (str [0] + (str.Length - 2).ToString () + str [str.Length - 1]);
                } else {
                    Console.WriteLine (str);
                }

            }
        }

        static void Z118A ()
        {
            string str = Console.ReadLine ();
            str = str.ToLower ();
            str = str.Replace ("a", "");
            str = str.Replace ("o", "");
            str = str.Replace ("y", "");
            str = str.Replace ("e", "");
            str = str.Replace ("u", "");
            str = str.Replace ("i", "");
            for (int i = 0; i < str.Length; i++) {
                Console.Write ("." + str [i]);
            }


        }

        static void Z50A ()
        {
        
            string   [] strs = Console.ReadLine ().Split (' ');
            int N = Int32.Parse (strs [0]);
            int M = Int32.Parse (strs [1]);
            int result = 0;
            result = (N / 2) * M;
            N %= 2;
            M /= 2;
            result += M * N;
            Console.WriteLine (result);
        
        }

        static void Z158B ()
        {
            int n = Int32.Parse (Console.ReadLine ());
            string[] strs = Console.ReadLine ().Split (' ');
            int[] com = new int[4];
            for (int i = 0; i < 4; i++) {
                com [i] = 0;    
            }
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp = Int32.Parse (strs [i]);
                com [temp - 1]++;
            }
            int sum = com [3];
            temp = Math.Min (com [2], com [0]);
            com [2] -= temp;
            com [0] -= temp;
            sum += temp;
            sum += com [2];
            sum += com [1] / 2;
            com [1] %= 2;
            sum += com [1];
            com [0] -= com [1] * 2;
            if (com [0] > 0) {
            
                sum += com [0] / 4;
                com [0] %= 4;
                if (com [0] > 0)
                    sum++;
            }
            Console.WriteLine (sum);

        }

        static void Z231A ()
        {
        
            int n = Int32.Parse (Console.ReadLine ());
            string[] strs;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                strs = Console.ReadLine ().Split (' ');
                if (Int32.Parse (strs [0]) + Int32.Parse (strs [1]) + Int32.Parse (strs [2]) > 1)
                    sum++;
            }
            Console.WriteLine (sum);
        }

        static void Z282A ()
        {
            
            int n = Int32.Parse (Console.ReadLine ());
            int x = 0;
            string str;
            for (int i = 0; i < n; i++) {
                str = Console.ReadLine ();
                str = str.Replace ("X", "");
                if (str == "++") {
                    x++;
                } else {
                    x--;
                }
            }
            Console.WriteLine (x);
        }

        static  void Z116A ()
        {
            
            int n = Int32.Parse (Console.ReadLine ());
            int a = 0, b = 0;
            int sum = 0;
            int max = 0;
            string [] strs;
            for (int i = 0; i < n; i++) {
                strs = Console.ReadLine ().Split (' ');
                a = Int32.Parse (strs [0]);
                b = Int32.Parse (strs [1]);
                sum -= a;
                sum += b;
                if (sum > max) {
                    max = sum;
                }
            }
            Console.WriteLine (max);
        }

        static void Z131A ()
        {
            bool caps = true;
            string str = Console.ReadLine ();
            char first = str [0];
            for (int i = 1; i < str.Length; i++) {
                if (str [i] < 'A' || str [i] > 'Z')
                    caps = false;
            }
            if (caps) {
                str = str.ToLower ();
                if (first >= 'a' && first <= 'z')
                    first = first.ToString ().ToUpper () [0];
                else
                    first = first.ToString ().ToLower () [0];
                str = first + str.Substring (1);

            }
            Console.WriteLine (str);
        }

        static void Z96A ()
        {
            string str = Console.ReadLine ();
            int n = 0;
            char ch = 'w';
            for (int i = 0; i < str.Length; i++) {
                if (ch == str [i])
                    n++;
                else {
                    if (n >= 7) {
                        Console.WriteLine ("YES");
                        return;
                    }
                    ch = str [i];
                    n = 1;
                }
            }
            if (n < 7)
                Console.WriteLine ("NO");
            else
                Console.WriteLine ("YES");
        }

        static void Z266A ()
        {
            
            string str = Console.ReadLine ();
            str = Console.ReadLine ();
            int n = 0;
            int m = 0;
            char ch = ' ';
            for (int i = 0; i < str.Length; i++) {
                if (ch == str [i])
                    n++;
                else {
                    m += n;
                    ch = str [i];
                    n = 0;
                }
            }
            m += n;
            Console.WriteLine (m);
        }

        static void Z133A ()
        {
            string str = Console.ReadLine ();
            for (int i = 0; i < str.Length; i++) {
                if (str [i] == 'H' || str [i] == 'Q' || str [i] == '9') {

                    Console.WriteLine ("YES");
                    return;
                }

            }
            Console.WriteLine ("NO");
        
        
        }

        static void Z112A ()
        {
            string str1 = Console.ReadLine ();
            str1 = str1.ToLower ();
            string str2 = Console.ReadLine ();
            str2 = str2.ToLower ();
            int n = String.Compare (str1, str2);
            if (n != 0)
                Console.WriteLine (n / Math.Abs (n));
            else
                Console.WriteLine (0);
        }

        static void Z339A ()
        {
            int [] ch = new int[3];
            for (int i = 0; i < 3; i++) {
                ch [i] = 0;
            }
            string str = Console.ReadLine ();
            bool flag = false;
            for (int i = 0; i < str.Length; i++) {
                if (flag)
                    i++;
                else
                    flag = true;
                ch [Int32.Parse (str [i].ToString ()) - 1]++;
            }
            int j = 0;
            flag = false;
            while (j<3) {
                ch [j]--;
                
                if (ch [j] >= 0) {
                    if (flag) {
                        Console.Write ("+");
                    } else
                        flag = true;
                    Console.Write (j + 1);
                } else
                    j++;
            }
        }

        static void Z281A ()
        {
            string str = Console.ReadLine ();
            string f = str [0].ToString ();
            f = f.ToUpper ();
            str = f [0] + str.Substring (1);
            Console.Write (str);
        }

        static void Z82A ()
        {
            string[] names = new    string[5];
            names [0] = "Sheldon";
            names [1] = "Leonard";
            names [2] = "Penny";
            names [3] = "Rajesh";
            names [4] = "Howard";
            int n = Int32.Parse (Console.ReadLine ());
            int m = 5;
            while (m<n) {
                n -= m;
                m *= 2;
            }
            m /= 5;
            int i = 0;
            while (m<n) {
                n -= m;
                i++;
            }
            Console.Write (names [i]);
        }

        static void Z160A ()
        {
            int n = Int32.Parse (Console.ReadLine ());
            string[] str = Console.ReadLine ().Split (' ');
            List<int> moneys = new List<int> ();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                moneys.Add (Int32.Parse (str [i]));
                sum += moneys [i];
            }

            int[] armon = moneys.ToArray ();
            Array.Sort (armon);
            int blz = 0;
            int j = armon.Length - 1;
            int ni = 0;
            while (blz<=sum&&j>=0) {
                blz += armon [j];
                sum -= armon [j];
                j--;
                ni++;
            }
            Console.WriteLine (ni);
        }

        static void Z148A ()
        {
            int k=Int32.Parse(Console.ReadLine());
            int l=Int32.Parse(Console.ReadLine());
            int m=Int32.Parse(Console.ReadLine());
            int n=Int32.Parse(Console.ReadLine());
            int d=Int32.Parse(Console.ReadLine());
                int sum=0;
            
            for (int i = 1; i <= d; i++) {
                if(i%k==0||i%l==0||i%m==0||i%n==0)
                    sum++;
            }
            Console.WriteLine(sum);
        }
        static void Z236A ()
        {
            string str=Console.ReadLine();
            int n=0;
            string ne="";
            bool k;
            for (int i = 0; i < str.Length; i++) {
                k=false;
                for (int j = 0; j < ne.Length; j++) {
					if (str[i]==ne[j]) {
                        k=true;
                    }
                }
                if (!k) {
                        ne+=str[i];
                        n++;
                    }
            }
            if (n%2==0) {
                Console.WriteLine("CHAT WITH HER!");
            }
            else {
                Console.WriteLine("IGNORE HIM!");
            }
        }
        static int gdc (int left,int right)
        {
            while (left>0&&right>0) {
                if (left>right) {
                    left%=right;
                }
                else
                    right%=left;
            }
            return left+right;
        }
        static void Z119A ()
        {
            string[]str=Console.ReadLine().Split(' ');
            int[] ab=new int[2];

            ab[0]=Int32.Parse(str[0]);
            ab[1]=Int32.Parse(str[1]);
            int n=Int32.Parse(str[2]);
            int i=0;
            int m;
            while (true) {
                if(n==0)
                {
                    Console.WriteLine((i+1)%2);
                    return;
                }
                m=gdc(ab[i],n);
                n-=m;
                i=(i+1)%2;

            }

        }
        static void Z110A ()
        {
            string str=Console.ReadLine();
            int n=0;
            for (int i = 0; i < str.Length; i++) {
                if (str[i]=='4'||str[i]=='7') {
                    n++;
                }
            }
            if (n==4||n==7) {
                Console.WriteLine("YES");
            }
            else {
                Console.WriteLine("NO");
            }
        }
        static void Z467A ()
        {
            int n=Int32.Parse(Console.ReadLine());
            int res=0;
            string [] strs;
            for (int i = 0; i < n; i++) {
                strs=Console.ReadLine().Split(' ');
                if (Int32.Parse(strs[1])-Int32.Parse(strs[0])>=2) {
                    res++;
                }
            }
            Console.WriteLine(res);
        }
        static void Z271A ()
        {
            int n=Int32.Parse(Console.ReadLine());
            int []ye=new int[4];
            n++;
            for (int i = 0; i < 4; i++) {
                ye[i]=n/1000;
                n%=1000;
                n*=10;
            }
            bool flag=true;
            while (flag) {
                    for (int i = 0; i < 4; i++) {
                for (int j = 0; j < i; j++) {
                    if(ye[i]==ye[j])
                        {
                        ye[i]++;
                            
                            for (int k = i+1; k < 4; k++) {
                                ye[k]=0;
                            }
                            i--;
                        }
                }
            }
                flag=false;
                for (int i = 1; i < 4; i++) {
                    if(ye[i]==10)
                    {
                        ye[i]%=10;
                        ye[i-1]++;
                        flag=true;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                Console.Write(ye[i]);
            }
        
        }
        static void Z58A ()
        {
            string str=Console.ReadLine();
            str.ToLower();
            string sstr="hello";
            int j=0;
            for (int i = 0; i < str.Length; i++) {
                if(sstr[j]==str[i])
                    j++;
                if (j==sstr.Length) {
                    Console.WriteLine("YES");
                    return;
                }
            }
            Console.WriteLine("NO");
        }
        static void Z472A (){
            int n=Int32.Parse(Console.ReadLine());
            if (n%2==0) {
                Console.Write("4 ");
                Console.Write(n-4);
            }
            else {
                Console.Write("9 ");
                Console.Write(n-9);
            }
        }
        public static void Main ()
        {
            Z236A ();
        }

    }
}