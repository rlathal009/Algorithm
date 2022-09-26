import java.io.*;
import java.util.*;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            if(minHeap.size() == maxHeap.size()) maxHeap.add(Integer.parseInt(br.readLine()));
            else minHeap.add(Integer.parseInt(br.readLine()));

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }    
}
