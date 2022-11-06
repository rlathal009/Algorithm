import java.io.*;
import java.util.*;

public class BOJ_14503 {
    static int n, m, count;
    static int[][] map;
    static int dx[] = {0, 1, 0, -1}; //북동남서
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); //0 북, 1 동, 2 남, 3 서
        count++;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int direction) {
        //현재 위치 청소
        map[r][c] = -1;
        
        for(int i=0; i<4; i++) {
            direction = (direction + 3) % 4; //왼쪽 방향으로 변환
            int ny = r + dy[direction];
            int nx = c + dx[direction];

            //청소 안된 곳이 있으면 청소하고 dfs 다시 호출
            if(ny >= 0 && ny < n && nx >=0 && nx < m && map[ny][nx] == 0) {
                count++;
                dfs(ny, nx, direction);
                return;
            }
        }

        //네 방향 모두 청소가 이미 되어있거나 벽인 경우
        int back = (direction + 2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        //뒤로 가는것이 범위 안이고 벽이 아니라면
        if(by >= 0 && by<n && bx>=0 && bx<m && map[by][bx] != 1) {
            dfs(by, bx, direction);
        }
    }
}
