import java.io.*;
import java.util.*;

public class BOJ_1920 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static int binarySearch(int key) {
        int lo = 0;
        int hi = arr.length -1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(key<arr[mid]) {
                hi = mid -1;
            }
            else if (key > arr[mid]) {
                lo = mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
