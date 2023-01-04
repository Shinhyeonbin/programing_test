package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        backtracking(0, nums, list, res);
        return res;
    }

    private static void backtracking(int pos, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (pos >= nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            list.add(nums[pos]);
            backtracking(pos + 1, nums, list, res);
            list.remove(list.size() - 1);
            backtracking(pos + 1, nums, list, res);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};

        List<List<Integer>> result = subsets(A);

        System.out.println(result.toString());
    }
}
