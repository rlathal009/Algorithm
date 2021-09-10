import java.util.*;
public class Main {
	public String solution(String str) {
		String answer ="";
		int l=0, r=str.length()-1;
		char[] ch = str.toCharArray();
		while(l < r) {
			if( !Character.isAlphabetic(ch[l])) l++;
			else if( !Character.isAlphabetic(ch[r])) r--;
			else {
				char tmp = ch[l];
				ch[l++] = ch[r];
				ch[r--] = tmp;
			}
		}
		answer = String.copyValueOf(ch);
		return answer;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}

}
