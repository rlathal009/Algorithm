import java.io.*;
import java.util.*;

public class BOJ_2671 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String pattern = "^(100+1+|01)+$";

        if (input.matches(pattern)) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }
    
}
