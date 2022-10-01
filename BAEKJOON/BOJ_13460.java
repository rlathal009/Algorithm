import java.io.*;
import java.util.*;

class TwoBall {
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    public TwoBall(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

public class BOJ_13460 {

    static int n, m;
    static char[][] map;
    static boolean[][][][] visited;
    // static TwoBall twoBall;
    static int result = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(TwoBall twoBall) {
        Queue<TwoBall> q = new LinkedList<>();
        q.offer(twoBall);

        visited[twoBall.rx][twoBall.ry][twoBall.bx][twoBall.by] = true;

        while(!q.isEmpty()) {
            TwoBall now = q.poll();

            if(now.count > 10){
                result = -1;
                return;
            }

            // 파란색이 빠져나간 경우
            if(map[now.bx][now.by] == 'O') {
                continue;
            }

            // 빨간 색이 빠져나가고 파란색은 빠져 나가지않은 경우
            if(map[now.rx][now.ry] == 'O') {
                result = now.count;
                return;
            }

            for(int i=0; i<4; i++){
                //기울였을 때 파란 구슬이 도달하는 지점으로 이동
                int bx = now.bx;
                int by = now.by;
                while(true) {
                    bx += dx[i];
                    by += dy[i];
                    
                    //빠져나간 경우
                    if(map[bx][by] == 'O') break;
                    //벽을 만난 경우
                    else if(map[bx][by] == '#'){
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }

                //기울였을 때 빨간 구슬이 도달하는 지점으로 이동
                int rx = now.rx;
                int ry = now.ry;
                while(true) {
                    rx += dx[i];
                    ry += dy[i];

                    //빠져나간 경우
                    if(map[rx][ry] == 'O') break;
                    //벽을 만난 경우
                    else if (map[rx][ry] == '#'){
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }

                //두개의 위치가 동일하고 빠져나가는 위치가 아닌 경우
                if(bx == rx && by == ry && map[rx][ry] != 'O') {
                    //이동한 거리가 더 긴쪽이 덜 이동하게 처리
                    int r_dis = Math.abs(now.rx - rx) + Math.abs(now.ry - ry);
                    int b_dis = Math.abs(now.bx - bx) + Math.abs(now.by - by);

                    //빨간 구슬이 더 이동한 경우
                    if(r_dis > b_dis) {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                    //파란 구슬이 더 이동한 경우
                    else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                // 기울였을 때 구슬들이 도달하는 지점을 방문 처리 후 큐에 추가
                if(!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    q.offer(new TwoBall(rx, ry, bx, by, now.count + 1));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i=0; i<n; i++){
            String row = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }
        bfs(new TwoBall(rx, ry, bx, by, 0));
        System.out.println(result);
    }    
}