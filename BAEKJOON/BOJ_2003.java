import java.io.*;
import java.util.*;

public class BOJ_2003 {

    static int N, M;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(cnt);
    }    

    private static void twoPointer() {
        int sum = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while(sum<M && end < N)
                sum += arr[end++];
            if(sum ==  M)
                cnt++;
            sum -= arr[start];
        }
    }
}
