import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int div = s/n;
        int mod = s%n;
        
        if(div == 0) {
            return new int[] {-1};
        }
         
        int[] answer = new int[n];
        for(int i=n-1; i>=0; i--) {
            answer[i] = div;
            if(mod>0){
                answer[i]++;
                mod--;
            }
        }
        
        return answer;
    }
}