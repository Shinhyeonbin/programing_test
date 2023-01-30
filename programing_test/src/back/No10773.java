package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < count; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stack.pop();
            }
            else{
                stack.push(input);
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
