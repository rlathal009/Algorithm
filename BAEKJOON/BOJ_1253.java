import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        for(int i=0; i<N; i++){
            int findNumber = arr[i];

            int s = 0;
            int e = N -1;
            int sum = 0;

            while(s < e) {
                sum = arr[s] + arr[e];
                if(sum == findNumber){
                    if(s==i)
                        s++;
                    else if(e==i)
                        e--;
                    else{
                        answer++;
                        break;
                    }
                }

                if(sum > findNumber) e--;
                else if(sum < findNumber) s++;
            }
        }

        System.out.println(answer);
    }
    
}
