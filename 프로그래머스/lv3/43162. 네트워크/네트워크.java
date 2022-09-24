class Solution {
    boolean[] visited;
    int[][] arr;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        arr = computers;
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        visited[node] = true;
        
        for(int i=0; i<arr.length; i++){
            if (!visited[i] && arr[node][i]==1){
               dfs(i); 
            }
        }
        
    }
}