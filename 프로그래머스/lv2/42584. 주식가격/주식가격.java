import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<prices.length; i++){
            int idx = 1;
            while(i+idx<prices.length && prices[i]<=prices[i+idx]){
                idx++;
            }
            if(i+idx==prices.length) ans.add(idx-1);
            else ans.add(idx);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}