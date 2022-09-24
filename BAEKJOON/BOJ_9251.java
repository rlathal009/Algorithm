import java.io.*;
import java.util.*;

public class BOJ_9251 {
    static char[] str1;
    static char[] str2;

    static int[][] dp;

    // public static void main(String[] args) throws IOException {
    //     //top-down 방식, 재귀
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     str1 = br.readLine().toCharArray();
    //     str2 = br.readLine().toCharArray();

    //     dp = new Integer[str1.length][str2.length];
    //     System.out.println(LCS(str1.length-1, str2.length-1));
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;

        dp = new int[len1+1][len2+1];

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[len1][len2]);

    }


    // private static int LCS(int x, int y) {
    //     //index 범위 체크
    //     if(x==-1 || y==-1) {
    //         return 0;
    //     }

    //     if(dp[x][y] == null){
    //         dp[x][y] = 0;

    //         if(str1[x] == str2[y]) {
    //             dp[x][y] = LCS(x-1, y-1) + 1;
    //         }
    //         else{
    //             dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
    //         }
    //     }

    //     return dp[x][y];
    // }
}
