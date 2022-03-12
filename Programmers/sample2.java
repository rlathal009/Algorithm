import java.util.*;

class sample2 {
    public boolean isPrime(int n) {
        if (n==0 || n==1) return false;
        for(int i=2; i<n; i++){
            if (n%i == 0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        int answer = 0;
        int size = numbers.length();
        return answer;
    }
}