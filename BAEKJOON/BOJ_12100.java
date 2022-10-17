import java.io.*;
import java.util.*;

public class BOJ_12100 {

    static int n, answer;
    static int[][] map, temp;
    static int[] direct;
    static boolean[][] visit;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[n][n];
        direct = new int[5];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }    

    public static void dfs(int index) {
        if(index == 5) {
            confirm();
            return;
        } else {
            for(int i=0; i<4; i++) {
                direct[index] = i;
                dfs(index+1);
            }
        }
    }

    public static void confirm() {
        temp = new int[n][n];
        for(int i=0; i<n; i++) {
            temp[i] = map[i].clone();
        }

        for(int d=0; d<direct.length; d++) {
            visit = new boolean[n][n];

            if(direct[d] == 0) {//상
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        move(i, j, direct[d]);
                    }
                }
            } else if (direct[d] == 2) { //하
                for(int i=n-1; i>=0; i--) {
                    for(int j=0; j<n; j++) {
                        move(i, j, direct[d]);
                    }
                }
            } else if(direct[d] == 1) { //우
                for(int i=n-1; i>=0; i--) {
                    for(int j=0; j<n; j++) {
                        move(j, i, direct[d]);
                    }
                }
            } else { //좌
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        move(j, i, direct[d]);
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer = Math.max(answer, temp[i][j]);
            }
        }
    }

    public static void move(int x, int y, int dir) {

        if(temp[x][y] == 0) {
            return;
        }

        while(true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny<0 || nx>=n || ny>=n) {
                return;
            }
            if (visit[nx][ny]) return;

            if(temp[nx][ny] == temp[x][y]) {
                visit[nx][ny] = true;
                temp[nx][ny] *= 2;
                temp[x][y] = 0;
                return;
            } else if(temp[nx][ny] != 0) return;

            temp[nx][ny] = temp[x][y];
            temp[x][y] = 0;
            x = nx;
            y = ny;
        }
    }

}
