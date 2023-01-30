package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No10828 {
    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int back = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push": {
                    int x = Integer.parseInt(st.nextToken());
                    stack.add(x);
                    back = x;
                    break;
                }
                case "pop": {
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n"   );
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                }
                case "size": {
                    sb.append(stack.size()).append("\n");
                    break;
                }
                case "empty": {
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "top": {
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}

