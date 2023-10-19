package leetcode;

public class no338 {
	public static int help(int arr[], int n) {
		if(arr[n/2] != -1) {
			return arr[n/2] +  n % 2;
		}
		else {
			arr[n] = arr[n/2] + n % 2;
			return arr[n];
		}
	}

	public static int[] countBits(int n) {
		
		int[] arr = new int[n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			arr[i] = -1;
		}
		
		arr[0] = 0;
		
		for(int i = 1; i < n + 1; i++) {
			arr[i] = help(arr, i);
		}
        
        return arr;
    }
	
	public static void main(String[] args) {
		int[] A = countBits(6);
		
		for(int i : A) {
			System.out.println(i);
		}
	}

}
