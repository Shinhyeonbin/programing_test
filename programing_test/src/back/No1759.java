package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759 {
    static int L;
    static int C;
    static char[] word;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        word = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < C; i++){
            word[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(word);

        backtracking(0, 0);
    }

    static void backtracking(int start,int cnt) {
        if(cnt==L) {
            int collection = 0;
            int Consonant = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<C;i++) {
                if(visited[i]) {
                    sb.append(word[i]);
                    if(word[i] =='a'||word[i]=='e'||word[i]=='i'||word[i]=='o'||word[i]=='u') {
                        collection++;
                    }else {
                        Consonant++;
                    }
                }
            }
            if(collection>=1 && Consonant>=2)
                System.out.println(sb);
        }
        for(int i=start;i<C;i++) {
            visited[i]=true;
            backtracking(i+1,cnt+1);
            visited[i]=false;
        }
    }
}
