import java.util.*;

class Solution {
    ArrayList<Integer>[] adj;
    int[] visit;
    int depth = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for(int[] e : edge){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        bfs(1,1);
        
        for(int i=1; i<=n; i++){
            if(depth==visit[i]) answer+=1;
        }
        
        return answer;
    }
    
    private void bfs(int start, int count) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(count);
        visit[start] = count;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            int n = q.poll();
            
            if(depth<n) depth = n;
            for(int i=0; i<adj[node].size(); i++){
                int next = adj[node].get(i);
                
                if(visit[next]!=0) continue;
                visit[next] = n+1;
                q.add(next);
                q.add(n+1);
            }
        }
    }
}