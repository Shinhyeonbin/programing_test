package leetcode;

public class no198 {
	public static int re(int[] nums,  int i) {
		if(i == 0) {
			return nums[0];
		}
		if(i == 1) {
			return Math.max(nums[0], nums[1]);
		}
		
		int case1, case2;
		
		case1 = re(nums, i - 2) + nums[i];	//텀
		case2 = re(nums, i - 1);	//털지않음
		
		
		return Math.max(case1, case2);
	}
	
	public static int rob(int[] nums) {
		return re(nums, nums.length - 1);       
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,3,1};
		
		System.out.println(rob(A));
		
	}
}
