// PROBLEM: 207. Course Schedule


// Topological sort BFS.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     
        int[] indegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        List<Integer>[] adj = new List[numCourses];
        
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
                count++;
            }
        }
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int i : adj[current]) {
                if(!visited[i]) {
                    indegree[i]--;
                    
                    if(indegree[i] == 0) {
                        queue.offer(i);
                        visited[i] = true;
                        count++;
                    }
                }
            }
        }
        
       // System.out.println(count);
        if(count == numCourses) {
            return true;
        }
        
        return false;
        
    }
}