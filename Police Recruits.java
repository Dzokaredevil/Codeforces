import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
    public static int ONLINE_MODE = 1;
    public static int OFFLINE_MODE = 2;

    public int mode = 0;

    public Scanner in = null;
    public BufferedWriter out = null;

    public Main(int mode, Scanner in, BufferedWriter out) {
        this.mode = mode;
        this.in = in;
        this.out = out;
    }

    public void open() {
        if (mode == Main.ONLINE_MODE) {
            in = new Scanner(System.in);
            out = new BufferedWriter(new OutputStreamWriter(System.out));
        }
    }

    public void close() {
        in.close();
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void echo(String output) {
        try {
            out.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void echos(Collection collection, String separator) {
        StringBuffer sb = new StringBuffer();
        for (Object sentence : collection) {
            sb.append(sentence.toString() + separator);
        }
        String output = sb.toString().length() > 0 ?
                sb.toString().substring(0, sb.toString().length() - separator.length()) : sb.toString();
        echo(output);
    }

    public void echo(String format, Object... args) {
        String output = String.format(format, args);
        try {
            out.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main(Main.ONLINE_MODE, null, null);
        main.open();
        main.execute();
        main.close();
    }

    // 工具方法

    public static int up(double num) {
        return (int) Math.ceil(num);
    }

    public static ArrayList<Character> chars(String word) {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char letter : word.toCharArray()) {
            chars.add(letter);
        }
        return chars;
    }

    // 临时区

    // 主程序

    public void execute() {
        int N = in.nextInt();
        int count = 0;
        int num = 0;
        for (int n = 0; n < N; n++) {
            int a = in.nextInt();
            if (a > 0)
                num += a;
            else if (num > 0)
                num--;
            else
                count++;
        }
        echo("%d%n", count);
    }
}

class BI {
    public BigInteger bi;

    public BI(String value) {
        this.bi = new BigInteger(value);
    }

    public BI(BigInteger bi) {
        this.bi = bi;
    }

    public BI a(BI that) {
        return new BI(this.bi.add(that.bi));
    }

    public BI s(BI that) {
        return new BI(this.bi.subtract(that.bi));
    }

    public BI m(BI that) {
        return new BI(this.bi.multiply(that.bi));
    }

    public BI d(BI that) {
        return new BI(this.bi.divide(that.bi));
    }

    public BI r(BI that) {
        return new BI(this.bi.remainder(that.bi));
    }

    public int compareTo(BI that) {
        return this.bi.compareTo(that.bi);
    }

    public boolean g(BI that) {
        return this.bi.compareTo(that.bi) > 0;
    }

    public boolean ge(BI that) {
        return this.bi.compareTo(that.bi) >= 0;
    }

    public boolean l(BI that) {
        return this.bi.compareTo(that.bi) < 0;
    }

    public boolean le(BI that) {
        return this.bi.compareTo(that.bi) <= 0;
    }

    public BI a(int number) {
        return a(BI.v(number));
    }

    public BI s(int number) {
        return s(BI.v(number));
    }

    public BI m(int number) {
        return m(BI.v(number));
    }

    public BI d(int number) {
        return d(BI.v(number));
    }

    public BI r(int number) {
        return r(BI.v(number));
    }

    public int compareTo(int number) {
        return this.bi.compareTo(BI.v(number).bi);
    }

    public boolean g(int number) {
        return this.bi.compareTo(BI.v(number).bi) > 0;
    }

    public boolean ge(int number) {
        return this.bi.compareTo(BI.v(number).bi) >= 0;
    }

    public boolean l(int number) {
        return this.bi.compareTo(BI.v(number).bi) < 0;
    }

    public boolean le(int number) {
        return this.bi.compareTo(BI.v(number).bi) <= 0;
    }

    public static BI v(int number) {
        return new BI("" + number);
    }

    public String toString() {
        return this.bi + "";
    }
}