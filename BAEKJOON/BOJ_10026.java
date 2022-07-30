import java.io.*;
import java.util.*;

public class BOJ_10026 {

    static int N;
    static char[][] grid;
    static int[][] pictures, patient;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pictures = new int[N][N];
        patient = new int[N][N];
        grid = new char[N][N];

        for(int i=0; i<N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int cnt = 0, paitentCnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(pictures[i][j] == 0){
                    cnt++;
                    dfs(i, j, grid[i][j], cnt);
                }

                if(patient[i][j] == 0) {
                    paitentCnt++;
                    patientDFS(i, j, grid[i][j], cnt);
                }
            }
        }
        System.out.println(cnt + " " + paitentCnt);

    }

    static void patientDFS(int y, int x, char color, int cnt) {
        patient[y][x] = cnt;

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX <0 || nextX >=N || nextY<0 || nextY>=N ) continue;
            if(patient[nextY][nextX] != 0) continue;

            char nextColor = grid[nextY][nextX];
            if(nextColor == color) {
                patientDFS(nextY, nextX, nextColor, cnt);
            } else{
                if((color == 'R' && nextColor == 'G') || (color=='G' && nextColor =='R')) {
                    patientDFS(nextY, nextX, nextColor, cnt);
                }
            }
        }

    }

    static void dfs(int y, int x, char color, int cnt) {
        pictures[y][x] = cnt;

        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX <0 || nextX >=N || nextY<0 || nextY>=N ) continue;
            if(pictures[nextY][nextX] != 0) continue;

            char nextColor = grid[nextY][nextX];
            if(nextColor == color) {
                dfs(nextY, nextX, nextColor, cnt);
            }
        }

    }
        
}
