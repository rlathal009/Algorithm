import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_Intern_1 {

    static int[] arr;
    static ArrayList<Integer> answer = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int q = Integer.parseInt(br.readLine());

            /**query가 들어오지 않을 경우 예외 처리**/
            for(int k=0; k<q; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                if(st.hasMoreTokens()!=true) {
                    answer.add(-1);
                    break;
                }
                int x = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                maxXor(x, m);
            }
        }

        for(int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void maxXor(int x, int m) {
        int max = 0, idx = -1, it=-1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= m) it = i;
        }
        if(it<0){
            answer.add(-1);
            return;
        }
        for(int j=0; j<it; j++) {
            if(max< (x^arr[j])) {
                max = (x^arr[j]);
                idx = j;
            }
        }
        answer.add(arr[idx]);
    }
}
