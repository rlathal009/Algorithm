import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            String operator = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if(operator.equals("I")){
                pq.offer(value);
                maxPq.offer(value);
            }
            else if (!pq.isEmpty()){
                if(value==1){
                    int max = maxPq.poll();
                    pq.remove(max);
                }
                else{
                    int min = pq.poll();
                    maxPq.remove(min);
                }
            }
        }
        
        if(!pq.isEmpty()){
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}