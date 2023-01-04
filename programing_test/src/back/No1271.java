package back;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class No1271 {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner (System. in);
        BigInteger A= scanner.nextBigInteger() ;
        BigInteger B= scanner.nextBigInteger();
        scanner.close();
        System.out.println(A.divide(B));
        System.out.println(A.remainder (B)) ;
    }
}
