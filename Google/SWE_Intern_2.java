import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWE_Intern_2 {

    public static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            count(N, X, Y);
        }

        for(int ans : answer) {
            System.out.println(ans);
        }
    }

    //최대공약수
    public static int gcd(int a, int b) {
        return (a%b) != 0 ? gcd(b, a%b) : b;  //유클리드 호제법
    }

    public static void count(int n, int x, int y) {
        int cnt = 0, num;
        num = x*y / gcd(x, y);  //최소공배수

        for(int i=num; i<Math.pow(10, n); i+= num) {  //자리수 체크
            if(i> Math.pow(10, n-1)) {
                cnt++;
            }
        }
        answer.add(cnt % ((int)Math.pow(10, 9) + 7));
    }
    
}
