package back;

public class test {
    public static void main(String[] args) {
        int i = 0, h = 0;

        for(i = 1; i <= 5; ++i, h += i){
            System.out.printf("%d, %d", i, h);
            System.out.println();
        }

    }
}
