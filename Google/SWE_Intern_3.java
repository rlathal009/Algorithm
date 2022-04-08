import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Comparator;

public class SWE_Intern_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int op = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(op == 0) {
                arr.add(num);
            }
            else {
                for(int j=0; j<arr.size(); j++) {
                    int change = arr.get(j)^num;
                    arr.set(j, change);
                }
            }
        }

        arr.sort(Comparator.naturalOrder());  //오름차순 정렬

        for(int x : arr){
            System.out.print(x+" ");
        }

    }
    
}
