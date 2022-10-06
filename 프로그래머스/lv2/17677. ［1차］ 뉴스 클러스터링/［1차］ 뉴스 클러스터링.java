import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(Character.isLetter(a) && Character.isLetter(b)){
                list1.add(Character.toString(a) + Character.toString(b));
            }
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(Character.isLetter(a) && Character.isLetter(b)) {
                list2.add(Character.toString(a) + Character.toString(b));
            }
        }
        
        // Collections.sort(list1);
        // Collections.sort(list2);
        
        for(String s : list1) {
            if(list2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }
        
        for(String s : list2) {
            union.add(s);
        }
        
        double jacard = 0;
        
        if(union.size()==0){
            jacard = 1;
        }
        else{
            jacard = (double)intersection.size()/(double)union.size();
        }
        
        return (int) (jacard*65536);
    }
}