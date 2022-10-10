import java.util.*;
import java.io.*;

public class Main {
    static int N, L;
    static int[][] map;
    static List<int[]> snake;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        StringTokenizer st;
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        int[][] dir = new int[L][2];
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();
            //방향 구현하는 방법 유의
            dir[i][1] = (temp.equals("L")) ? -1 : 1;
        }

        int time = solution(dir);
        System.out.println(time);
    }    

    private static int solution(int[][] dir) {
        int curX = 0, curY = 0;
        int time = 0;
        int currentDir = 0;
        int turn = 0;

        while (true) {
            time++;
            int nextX = curX + dx[currentDir];
            int nextY = curY + dy[currentDir];

            if(isFinish(nextX, nextY)) break;

            if(map[nextX][nextY] == 1){
                map[nextX][nextY] = 0;
                snake.add(new int[]{nextX, nextY});
            } else{
                snake.add(new int[]{nextX, nextY});
                snake.remove(0);
            }

            curX = nextX;
            curY = nextY;

            if(turn < L) {
                if(time == dir[turn][0]) {
                    currentDir = nextDir(currentDir, dir[turn][1]);
                    turn++;
                }
            }
        }

        return time;
    }

    private static int nextDir(int current, int dir) {
        int next = (current+dir) % 4;
        if(next ==-1) next = 3;

        return next;
    }

    private static boolean isFinish(int x, int y) {
        if(x<0 || y<0 || x>N-1 || y>N-1) return true;

        for(int i=0; i<snake.size(); i++) {
            int[] t = snake.get(i);
            if(x == t[0] && y == t[1]) {
                return true;
            }
        }

        return false;
    }
}
