class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] inDegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            inDegree[prerequisites[i][1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int adj : adjList.get(node)){
                inDegree[adj]--;
                if(inDegree[adj] == 0){
                    q.add(adj);
                }
            }
        }
        
        return count == numCourses;
    }
}
