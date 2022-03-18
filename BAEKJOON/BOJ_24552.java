import java.io.*;

public class BOJ_24552 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int left=0, right=0, sum=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            } else{
                right++;
            }
        }

        if(left>right){
            left = 0;
            right = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '(') left++;
                else right++;
                if(left == right){
                    left = 0;
                    right = 0;
                }
            }
            System.out.println(left);
        }
        else {
            left = 0;
            right = 0;
            for(int i= s.length()-1; i>=0; i--){
                if(s.charAt(i) == '(') left++;
                else right++;
                if(left == right){
                    left = 0;
                    right = 0;
                }
            }
            System.out.println(right);
        }
    }
}
