package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] check = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            int result = binarySearch(arr, 0, arr.length - 1, check[i]);
            System.out.println(result);
        }

    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (target == arr[mid]) {
                return 1;
            } else {
                if (target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }
}
