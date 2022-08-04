import java.util.*;
import java.io.*;

public class Main {
    private static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][2*N-1];
        for(int i=0; i<N; i++){
            for(int j=0; j<2*N-1; j++){
                map[i][j] = ' ';
            }
        }

        drawStar(0, N-1, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<2*N-1; j++){
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void drawStar(int x, int y, int n){
        if(n==3){
            map[x][y] = '*';
            map[x+1][y-1] = map[x+1][y+1] = '*';
            map[x+2][y-2] = map[x+2][y-1] = map[x+2][y] = map[x+2][y+1] = map[x+2][y+2] = '*';
            return;
        }

        drawStar(x, y, n/2);
        drawStar(x + n/2, y - n/2, n/2);
        drawStar(x + n/2, y + n/2, n/2);
    }
    
}
