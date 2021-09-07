import java.util.*;
public class Main {
	public String solution(String str) {
		String answer = "";
		
		for(char ch : str.toCharArray()) {
			if(ch>='A' && ch <='Z') {
				ch+=('a'-'A');
				answer += ch;
			}
			else {
				ch-=('a'-'A');
				answer+= ch;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}

}
