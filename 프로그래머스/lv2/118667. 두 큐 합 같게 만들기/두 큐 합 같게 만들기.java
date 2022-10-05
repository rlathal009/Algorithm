import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int q : queue1) {
            sum1 += q;
            q1.add(q);
        }
        
        for(int q : queue2) {
            sum2 += q;
            q2.add(q);
        }
        
        while(sum1 != sum2) {
            if(answer > 4*queue1.length) return -1;
            answer++;
            if(sum1 > sum2) {
                int temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            }
            else {
                int temp = q2.poll();
                q1.add(temp);
                sum2 -= temp;
                sum1 += temp;
            }
        }
        
        
        return answer;
    }
}