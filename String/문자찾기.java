import java.util.*;
public class Main {
	public int solution(String str, char t) {
		int answer = 0;
		
		str = str.toLowerCase();
		t = Character.toLowerCase(t);
		
		for(char ch : str.toCharArray()) {
			if(ch == t) answer++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		
		System.out.print(T.solution(str, c));
	}

}
