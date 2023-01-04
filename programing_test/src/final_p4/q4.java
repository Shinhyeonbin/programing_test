package final_p4;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class q4
{
    /*
    식:  𝑦 = sin2𝑥 + cos3𝑥 + 2 +

    sin2x = -1/2 cos2x
    cos3x = 1/3 sin3x
    2 = 2x?

    Y = -1/2 cos2x + 1/3sin3x + 2x + C => 적분한식?
    => result F(b) - F(a)

    무작위화 기법을 활용해서 구하라... => x의 무작위?

    */
    public static double solution()
    {
        double result = 0.0;
        for(int i = 0; i < 100000; i++){
            double x1 = Math.random() * 5;
            double x2 = (Math.random() * 5) + x1;

            double cal1 = ((1 / 2) * Math.cos(2 * (x1))) + ((1/3) * Math.sin(3 * (x1))) + (2 * (x1));
            double cal2 = ((1 / 2) * Math.cos(2 * (x2))) + ((1/3) * Math.sin(3 * (x2))) + (2 * (x2));

            double cal = cal2 - cal1;

            if(result == cal){
                break;
            }
            else if(result < cal){
                result = cal;
            }

        }
        return result;
    }   

    public static void main(String[] args)
    {
        // DO NOT EDIT. Open files
        try {
            FileWriter output = new FileWriter("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p4/output.txt"); // your answer
   
            long start_time = System.currentTimeMillis();
            double result = solution();
            output.write(Math.round(result * 100) / 100.0 + "\n");
            output.close();
            long end_time = System.currentTimeMillis();
            // DO NOT EDIT. Checking answers
            System.out.printf("Elapsed time: %.2f seconds. ", (float)(end_time - start_time) / 1000);
            compare_output("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p4/output.txt", "/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p4/expected.txt");
        } catch (IOException e) {
            System.out.println("FileWriter error");
            e.printStackTrace();
        }
    }

    public static void compare_output(String file1, String file2)
    {
        File f1 = new File(file1);
        File f2 = new File(file2);
        try {
            Scanner result = new Scanner(f1);
            Scanner expected = new Scanner(f2);

            int i = 1;
            Boolean success = true;

            while(result.hasNextLine() && expected.hasNextLine()) {
                String line1 = result.nextLine().trim();
                String line2 = expected.nextLine().trim();
                if (!line1.equals(line2)) {
                    System.out.println("[" + i + "] Wrong answer: Yours=\'" + line1 + "\', Expected=\'" + line2 + "\'");
                    success = false;
                    break;
                }
                i++;
            }
            if (!expected.hasNextLine() && success) System.out.println("Success!");
            result.close();
            expected.close();
        } catch (IOException e) {
           System.out.println("FileWriter error");
            e.printStackTrace();
        }
    }
}
