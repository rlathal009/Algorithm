import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_15811 {
    public static char[][] words = new char[3][20];
    public static int[] numbers = new int[3];
    public static int[] numOfAlphabet = new int[26];
    public static boolean[] usedNumber = new boolean[11];
    public static boolean flag = false;
    // public static List<Character> alphabet = new ArrayList<>();
    public static String temp;
    public static Map<Character, Integer> alphabet = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3; i++) {
            words[i] = st.nextToken().toCharArray();
            for(int j=0; j<words[i].length; j++) {
                if(!alphabet.containsKey(words[i][j])) {
                    alphabet.put(words[i][j], -1);
                }
                // if(!alphabet.contains(words[i][j])) {
                    // alphabet.add(words[i][j]);
                // }
            }
        }
        
        // alphabet이 10개 초과하여 들어온 경우 종료
        if(alphabet.size() > 10) {
            System.out.println("NO");
            return;
        }
        
        temp = alphabet.keySet().toString();
        
        dfs(0);

        String answer = flag ? "YES" : "NO";
        System.out.println(answer);

        return;
    }

    public static void dfs(int depth) {
        if(depth == alphabet.size()) {
            for(int i=0; i<3; i++) {
                numbers[i] = getNumber(String.valueOf(words[i]));
            }
            if(numbers[0] + numbers[1] == numbers[2]) {
                flag = true;
            }
            return;
        }

        // int idx = alphabet.get(depth) - 'A';
        for(int i=0; i<10; i++) {
            // if(usedNumber[i]) continue;
            if(alphabet.entrySet().contains(i)) continue;
            // usedNumber[i] = true;
            alphabet.put(temp.charAt(depth), i);
            // numOfAlphabet[idx] = i;
            dfs(depth + 1);
            // usedNumber[i] = false;
            alphabet.put(temp.charAt(depth), -1);
        }

    }

    public static int getNumber(String str) {
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            // result = result * 10 + numOfAlphabet[str.charAt(i) - 'A'];
            result = result * 10 + alphabet.get(str.charAt(i));

        }

        return result;
    }
}
