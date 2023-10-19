package pratice;

public class adf {
    public static void main(String[] args) {
        int m = 4620;

        int a = m / 1000;
        int b = (m % 1000) / 500;
        int c = (m % 500) / 100;
        int d = (((m % 1000) % 500) % 100) / 10;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
