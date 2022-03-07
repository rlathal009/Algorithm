import java.util.*;
import java.io.*;

public class BOJ_11286 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReser(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1>o2 ? 1 : -1;
            return abs1 - abs2;
        });

        for(int i=0; i<n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val==0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{
                queue.add(val);
            }
        }
    }
}
