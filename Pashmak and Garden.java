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

    public void execute() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        x.add(in.nextInt());
        y.add(in.nextInt());
        x.add(in.nextInt());
        y.add(in.nextInt());
        if (x.get(0) == x.get(1)) {
            if (y.get(0) == y.get(1))
                echo("-1");
            else {
                echo("%d %d %d %d", x.get(0) + y.get(1) - y.get(0), y.get(0), x.get(0) + y.get(1) - y.get(0), y.get(1));
            }
        } else if (y.get(0) == y.get(1)) {
            echo("%d %d %d %d", x.get(0), y.get(0) + x.get(1) - x.get(0), x.get(1), y.get(0) + x.get(1) - x.get(0));
        } else {
            int gap1 = (int) Math.abs(x.get(0) - x.get(1));
            int gap2 = (int) Math.abs(y.get(0) - y.get(1));
            if (gap1 != gap2)
                echo("-1");
            else {
                echo("%d %d %d %d", x.get(0), y.get(1), x.get(1), y.get(0));
            }
        }
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
