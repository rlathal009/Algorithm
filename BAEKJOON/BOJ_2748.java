import java.io.*;

public class BOJ_2748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long n1 = 0, n2 = 1;
        long sum = 1;
        for(int i = 1; i < n; i++){
            sum = n1+n2;
            n1 = n2;
            n2 = sum;
        }

        System.out.println(sum);
    } 
}
