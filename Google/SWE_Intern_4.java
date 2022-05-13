import java.io.IOException;
import java.util.*;

public class SWE_Intern_4 {
    public static void main(String[] args) throws IOException {
        Integer[] data = {2, 6, 2, 8, 4, 5};
        Arrays.sort(data, Collections.reverseOrder());
        int[] dp = new int[data.length];
        dp[0] = data[0];
        int cnt=1;

        for(int i=1; i<5; i++) {
            if(dp[i-1] >= (dp[i-1] | data[i])) {
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = dp[i-1] | data[i];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    
}