package final_p2;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

/*
차이가 가장 작게 만드는 방법 -> 일단 정렬 -> 그리디인가...?

그리디는 아니다.... => 백트레킹 재귀형식으로 접근

 */
public class q2
{
    public static int solution(int[] nums, int n)
    {
        int sum=0;

        for(int i=0; i<nums.length; i++)
            sum+=nums[i];

        List<Integer> list=new ArrayList<>();
        backTracking(nums, 0, 0, 0, list);

        int ans=Integer.MAX_VALUE;
        for(int i=0; i<=list.size()/2; i++)
            ans=Math.min(ans, Math.abs(sum-list.get(i)-list.get(i)));

        return ans;
    }
    private static void backTracking(int[] nums, int pos, int sum, int depth, List<Integer> list) {
        if(depth == nums.length/2) {
            list.add(sum);
            return;
        }
        if(pos == nums.length)
            return;

        backTracking(nums, pos+1, sum+nums[pos], depth+1, list);
        backTracking(nums, pos+1, sum, depth, list);
    }

    public static void main(String[] args)
    {
        // DO NOT EDIT. Open files
        try {
            File input = new File("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p2/input.txt"); // input data
            FileWriter output = new FileWriter("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p2/output.txt"); // your answer
   
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
            compare_output("/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p2/output.txt", "/Users/hyeonbinshin/git/programing_test/programing_test/src/final_p2/expected.txt");
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
