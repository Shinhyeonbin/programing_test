package back;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class No2338 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
    }
}
