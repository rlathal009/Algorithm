import java.io.*;
import java.util.*;

public class Main {

    static class tomato{
        int x;
        int y;
        int z;
    
        tomato(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static int M, N, H;
    static int[][][] tomatoes;
    static Queue<tomato> queue;

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];
        queue = new LinkedList<tomato>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoes[i][j][k] == 1){
                        queue.add(new tomato(i,j,k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        while(!queue.isEmpty()){
            tomato t = queue.poll();
            int x = t.x;
            int y = t.y;
            int z = t.z;

            for(int i=0; i<6; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && nextZ>=0 && nextZ<H && tomatoes[nextZ][nextX][nextY]==0){
                    queue.add(new tomato(nextZ, nextX, nextY));
                    tomatoes[nextZ][nextX][nextY] = tomatoes[z][x][y] + 1;
                }
            }
        }

        int days = Integer.MIN_VALUE;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(tomatoes[i][j][k] == 0) return -1;
                    else{
                        days = Math.max(days, tomatoes[i][j][k]);
                    }
                }
            }
        }

        return days-1;
    }
}
