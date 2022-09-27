public class ex1 {

    class Person{
        int row;
        int col;
        int dist;

        Person(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    Queue<Person> q = new LinkedList<Person>();

    public int solution(int[][] input){
        int answer = 0;
        int n = input.length;
        visited = new boolean[30][30];
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if(input[i][j] == 'C'){
                    q.add(new Person(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Person p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.row + dx[i];
                int ny = p.col + dy[i];
                int nextDist = p.dist +1;
                if(nextDist > 3) continue;
                if(nx < 0 || nx >= n || ny<0 || ny>=n) continue;
                if(visited[nx][ny] || input[nx][ny] == 'C') continue;
                
                q.add(new Person(nx, ny, nextDist));
                visited[nx][ny] = true;

                if(input[nx][ny] == 'M' && nextDist <= 2) answer++;
                if(input[nx][ny] == 'N' && nextDist <= 3) answer++;

            }
        }

        return answer;
    }
}
