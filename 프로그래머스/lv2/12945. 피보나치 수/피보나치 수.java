class Solution {
    public int DIV = 1234567;
    
    public int solution(int n) {
        int answer = 0;
        if(n==0 || n==1) return 1;
        int f1 = 0, f2 = 1;
        
        for(int i=2; i<=n; i++) {
            answer = (f1+f2) % DIV;
            f1 = f2;
            f2 = answer;
        }
        
        return answer;
    }
}