import java.util.*;
public class Main {
	public void solution(String[] str) {
		
		for(String x : str) {
			int len = x.length();
			for(int i =len-1; i>=0; i--)
				System.out.print(x.charAt(i));
			System.out.print("\n");
		}
	}
	
	
	//StringBuilder »ç¿ë
	public ArrayList<String> solution2(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		for(String x: str) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String[] str = new String[n];
		for(int i =0; i<n; i++)
			str[i] = kb.next();
		T.solution(str);
	}

}
