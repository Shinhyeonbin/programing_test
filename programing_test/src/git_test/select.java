package git_test;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class select
{
    public static int selectionsort(int[] nums, int k)
    {
        Arrays.sort(nums);
        // your code is here
        // -----------------------------------
        // -----------------------------------
        return(nums[k-1]);
    }   

    public static void main(String[] args)
    {
        // DO NOT EDIT. Open files
        try {
            File input = new File("/Users/hyeonbinshin/git/programing_test/programing_test/src/git_test/input_data.txt"); // input data
            FileWriter output = new FileWriter("/Users/hyeonbinshin/git/programing_test/programing_test/src/git_test/output_data.txt"); // your answer
   
            Scanner datain = new Scanner(input);
            int M = datain.nextInt();
            long start_time = System.currentTimeMillis();
            for(int i=0; i<M; i++) {
                int N = datain.nextInt();
                int k = datain.nextInt();
                int[] nums = new int[N];
                for(int j=0; j<N; j++) {
                    nums[j] = datain.nextInt();
                }

                int kth_element = selectionsort(nums, k);
                output.write(kth_element + "\n");
            }
            datain.close();
            output.close();
            long end_time = System.currentTimeMillis();
            // DO NOT EDIT. Checking answers
            System.out.printf("Elapsed time: %.2f seconds. ", (float)(end_time - start_time) / 1000);
            compare_output("/Users/hyeonbinshin/git/programing_test/programing_test/src/git_test/output_data.txt", "/Users/hyeonbinshin/git/programing_test/programing_test/src/git_test/expected_data.txt");
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
