import java.util.*;

class hashmap2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }
        
        return answer;
    }
    
//     public boolean solution2(String[] phone_book) {
//         boolean answer = true;
        
//         HashMap<String, Integer> map = new HashMap<>();
        
//         for(String phone : phone_book){
//             map.put(phone, 1);
//         }
        
//         for(int i=0; i< phone_book.length; i++){
//             for(int j=0; j<phone_book[i].length(); j++){
//                 if(map.containsKey(phone_book[i].substring(0,j)))
//                     return false;
//             }
//         }
        
//         return answer;
//     }
}