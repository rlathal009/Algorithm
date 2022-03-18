import java.io.*;
import java.util.*;

class tomato {
    int x;
    int y;

    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] tomatoes;
    static Queue<tomato> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        tomatoes = new int[n][m];
        q = new LinkedList<tomato>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1) q.add(new tomato(i,j));
            }
        }

        System.out.println(bfs(n,m));

    }
    
    public static int bfs(int n, int m){
        while(!q.isEmpty()){
            tomato t = q.poll();
            int x = t.x;
            int y = t.y;

            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if( nextX >= 0 &&  nextY>=0 && nextX<n && nextY<m && tomatoes[nextX][nextY] == 0){
                    q.add(new tomato(nextX, nextY));
                    tomatoes[nextX][nextY] = tomatoes[x][y] + 1;
                }
            }
        }

        int day = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tomatoes[i][j] == 0) return -1;
                day = Math.max(day, tomatoes[i][j]);
            }
        }

        return (day-1);
    }
}
