import java.util.*;
import java.io.*;

public class BOJ_14502 {
    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int dx[] = {1, -1, 0, 0};
    static final int dy[] = {0, 0, 1, -1};
    static int n, m;
    static int[][] map;
    static int maxSafeZone = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);
    }    

    static void dfs(int wallCnt) {
        //벽 3개 설치된 경우 bfs 탐색
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(map[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        int copyMap[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(copyMap[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        checkSafeZone(copyMap);
    }

    static void checkSafeZone(int[][] copyMap) {
        int safeZone = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(copyMap[i][j] == 0) safeZone++;
            }
        }

        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}
