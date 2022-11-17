import java.io.*;
import java.util.*;

public class BOJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] chapter = new int[K+1];
            int[][] dp = new int[K+1][K+1];
            int[] sum = new int[K+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=K; j++){
                chapter[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1] + chapter[j];
            }

            for(int n=1; n<=K; n++) {
                for(int from = 1; from+n <= K; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }
            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb);
    }
}
