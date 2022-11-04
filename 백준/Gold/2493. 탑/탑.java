import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<int[]> stack = new Stack<>();
        for(int i=1; i<=n; i++) {
            int v = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= v) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new int[]{i, v});
        }

        System.out.println(sb);
    }
}
