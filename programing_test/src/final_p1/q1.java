package final_p1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

/*
배열내용을 바꿀수있을때, sum의 값의 최대치... => 정렬하면 됨

 */
public class q1
{
    public static int solution(int[] nums, int n)
    {
        int sum = 0;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            sum += nums[i] * i;
        }

        return sum;
    }   

    public static void main(String[] args)
    {
        // DO NOT EDIT. Open files
        try {
            File input = new File("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p1/input.txt"); // input data
            FileWriter output = new FileWriter("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p1/output.txt"); // your answer
   
            Scanner datain = new Scanner(input);
            int K = datain.nextInt();
            long start_time = System.currentTimeMillis();
            for(int i=0; i<K; i++) {
                int n = datain.nextInt();
                int[] nums = new int[n];
                for(int j=0; j<n; j++) {
                    nums[j] = datain.nextInt();
                }
                int result = solution(nums, n);
                System.out.println(result);
                output.write(result + "\n");
            }
            datain.close();
            output.close();
            long end_time = System.currentTimeMillis();
            // DO NOT EDIT. Checking answers
            System.out.printf("Elapsed time: %.2f seconds. ", (float)(end_time - start_time) / 1000);
            compare_output("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p1/output.txt", "/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p1/expected.txt");
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
