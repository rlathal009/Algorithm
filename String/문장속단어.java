import java.util.*;
public class Main {
	public String solution(String str) {
		String answer = "";
		String tmp = "";
		for(char ch : str.toCharArray()) {
			if(ch!=' ') tmp+=ch;
			else {
				if(tmp.length()>answer.length()) answer = tmp;
				tmp = "";
			}
		}
		if(tmp.length()>answer.length()) answer = tmp;
		
		return answer;
	}
	
	
	public String solution2(String str) {
		String answer = "";
		int count = Integer.MIN_VALUE;
		String[] s = str.split(" ");
		for(String x : s) {
			if(x.length()>count) {
				answer = x;
				count = x.length();
			}
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.print(T.solution(str));
	}

}
