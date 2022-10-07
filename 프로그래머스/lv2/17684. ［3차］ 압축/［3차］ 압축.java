import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> dic = new HashMap<>();
        
        int idx = 1;
        for(char i = 'A' ; i <='Z'; i++) {
            dic.put(i+"", idx++);
        }
        
        int size = msg.length();
        for(int i=0; i<size; i++) {
            int a =1;
            while(i+a <= size && dic.containsKey(msg.substring(i, i+a))){
                a++;
            }
            if(i+a>size) {
                answer.add(dic.get(msg.substring(i)));
                break;
            }
            answer.add(dic.get(msg.substring(i, i+a-1)));
            dic.put(msg.substring(i, i+a), idx++);
            if(a>1) i+= a-2;
        }
        
        return answer;
    }
}