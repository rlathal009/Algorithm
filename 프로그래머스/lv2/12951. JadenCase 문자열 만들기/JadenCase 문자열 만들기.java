import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean space = true;
        
        for(String ss : sp) {
            answer += space ? ss.toUpperCase() : ss;
            space = ss.equals(" ") ? true : false;
        }
        
        return answer;
    }
}