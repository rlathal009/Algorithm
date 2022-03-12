import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11659 {
    public static  void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N+1];
        num[0] = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<N+1; i++){
            num[i] = num[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(num[end]-num[start-1]);
        }
    }
}
