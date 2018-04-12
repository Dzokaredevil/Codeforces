#region imports
using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
#endregion

namespace CodeForces
{
    class Problem
    {
        const bool IsContest = true;

        void Solve()
        {
            var a = _.NextToken();
            var nUpper = a.ToCharArray().Count(char.IsUpper);
            _.WriteLine(nUpper > a.Length - nUpper ? a.ToUpper() : a.ToLower());
        }

        int Dist(int s, int t, int[] d)
        {
            var dist = 0;
            for (var cur = s; cur != t; cur = (cur + 1) % d.Length) dist += d[cur];
            return dist;
        }

        #region shit
        private readonly InOut _ = new InOut(IsContest);
        static void Main(string[] args)
        {
            var p = new Problem();
            p.Solve();
            p._.Close();
        }
    }
    class InOut
    {
        private const string InputFile = "input.txt";
        private const string OutputFile = "output.txt";
        public StreamWriter Cout { get; private set; }
        public StreamReader Cin { get; private set; }
        private void SetConsoleIo()
        {
            Cin = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
            Cout = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));
        }
        private void SetFileIo(string inputFile, string outputFile) { Cin = new StreamReader(inputFile); Cout = new StreamWriter(outputFile); }
        public InOut() { SetConsoleIo(); }
        public InOut(string inputFile, string outputFile) { SetFileIo(inputFile, outputFile); }
        public InOut(bool isContest) { if (isContest) SetConsoleIo(); else SetFileIo(InputFile, OutputFile); }
        public void WriteLine(object x) { Cout.WriteLine(x); }
        public void Close() { Cin.Close(); Cout.Close(); }
        public void WriteLine(string format, params object[] args) { Cout.WriteLine(format, args); }
        private int _pos;
        private string[] _tokens;

        private string[] NextStringArray() { return Cin.ReadLine().Split(" \t".ToCharArray(), StringSplitOptions.RemoveEmptyEntries); }
        public string NextToken()
        {
            while (_tokens == null || _pos == _tokens.Length)
            {
                // ReSharper disable once PossibleNullReferenceException
                _tokens = NextStringArray();
                _pos = 0;
            }
            return _tokens[_pos++];
        }
        public int NextInt() { return int.Parse(NextToken()); }
        public long NextLong() { return long.Parse(NextToken()); }
        public double NextDouble() { return double.Parse(NextToken(), CultureInfo.InvariantCulture); }
        public int[] NextIntArray() { return NextStringArray().Select(int.Parse).ToArray(); }
        public long[] NextLongArray() { return NextStringArray().Select(long.Parse).ToArray(); }
        #endregion
    }
}