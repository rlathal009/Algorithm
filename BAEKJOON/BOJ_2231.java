import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    public static int solution(int n){
        for(int i = 0; i<n; i++){
            int sum = i;
            int number = i;
            while(number != 0){
                sum += number % 10;
                number /= 10;
            }
            if(sum == n) return i;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        System.out.println(solution(N));
    }
    
}
