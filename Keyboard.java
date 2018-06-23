import java.util.Scanner;

public class CF10 {
    public static void main ( String [] args ) {
        Scanner mos = new Scanner(System.in) ;
        String s = new String () ;
        char s1 = mos.next().charAt(0) ;
        s = mos.next() ;
        if ( s1 == 'R') {
            for ( int i = 0 ; i < s.length() ; i++ )
                switch ( s.charAt(i) )
                {
                case 'w' :
                    System.out.print("q");
                    break ;
                case 'e' :
                    System.out.print("w");
                    break ;
                case 'r' :
                    System.out.print("e");
                    break ;
                case 't' :
                    System.out.print("r");
                    break ;
                case 'y' :
                    System.out.print("t");
                    break ;
                case 'u' :
                    System.out.print("y");
                    break ;
                case 'i' :
                    System.out.print("u");
                    break ;
                case 'o' :
                    System.out.print("i");
                    break ;
                case 'p' : 
                    System.out.print("o");
                    break ;
                case 's' :
                    System.out.print("a");
                    break ;
                case 'd' :
                    System.out.print("s");
                    break ;
                case 'f' :
                    System.out.print("d");
                    break ;
                case 'g' :
                    System.out.print("f");
                    break ;
                case 'h' :
                    System.out.print("g");
                    break ;
                case 'j' :
                    System.out.print("h");
                    break ;
                case 'k' :
                    System.out.print("j");
                    break ;
                case 'l' :
                    System.out.print("k");
                    break ;
                case ';' :
                    System.out.print("l");
                    break ;
                case 'x' :
                    System.out.print("z");
                    break ;
                case 'c' :
                    System.out.print("x");
                    break ;
                case 'v' :
                    System.out.print("c");
                    break ;
                case 'b' :
                    System.out.print("v");
                    break ;
                case 'n' :
                    System.out.print("b");
                    break ;
                case 'm' :
                    System.out.print("n");
                    break ;
                case ',' :
                    System.out.print("m");
                    break ;
                case '.' :
                    System.out.print(",");
                    break ;
                case '/' :
                    System.out.print(".");
                    break ;
                }
            
        }
        else if ( s1 == 'L') {
            for ( int i = 0 ; i < s.length() ; i++ )
                switch ( s.charAt(i) )
                {
                case 'q' :
                    System.out.print("w");
                    break ;
                case 'w' :
                    System.out.print("e");
                    break ;
                case 'e' :
                    System.out.print("r");
                    break ;
                case 'r' :
                    System.out.print("t");
                    break ;
                case 't' :
                    System.out.print("y");
                    break ;
                case 'y' :
                    System.out.print("u");
                    break ;
                case 'u' :
                    System.out.print("i");
                    break ;
                case 'i' :
                    System.out.print("o");
                    break ;
                case 'o' :
                    System.out.print("p");
                    break ;
                case 'p' :
                    System.out.print("[");
                    break ;
                case 'a' :
                    System.out.print("s");
                    break ;
                case 's' :
                    System.out.print("d");
                    break ;
                case 'd' :
                    System.out.print("f");
                    break ;
                case 'f' :
                    System.out.print("g");
                    break ;
                case 'g' :
                    System.out.print("h");
                    break ;
                case 'h' :
                    System.out.print("j");
                    break ;
                case 'j' :
                    System.out.print("k");
                    break ;
                case 'k' :
                    System.out.print("l");
                    break ;
                case 'l' :
                    System.out.print(";");
                    break ;
                case 'z' :
                    System.out.print("x");
                    break ;
                case 'x' :
                    System.out.print("c");
                    break ;
                case 'c' :
                    System.out.print("v");
                    break ;
                case 'v' :
                    System.out.print("b");
                    break ;
                case 'b' :
                    System.out.print("n");
                    break ;
                case 'n' :
                    System.out.print("m");
                    break ;
                case 'm' :
                    System.out.print(",");
                    break ;
                case ',' :
                    System.out.print(".");
                    break ;
                case '.' :
                    System.out.print("/");
                    break ;
                }
            
        }
            
        }

}
