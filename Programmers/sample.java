import java.util.*;
import java.io.*;

class smaple {  
  public static String solution(String x){
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<x.length(); i++){
      char c = x.charAt(i);
      if(c=='(') stack.push(c);
      else if(stack.empty()) return "NO";
      else stack.pop();
    }

    if(stack.empty()) return "YES";
    else return "NO";
  }
  
  public static void main(String args[]) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String x = br.readLine();

    System.out.println(solution(x));
  }
}