class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        
        //Creating the adjList
        for(int i=0; i<prerequisites.length; i++){
            int pos = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            List<Integer> lst = adjList.getOrDefault(
                pre,
                new ArrayList<Integer>()
            );
            lst.add(pos);
            adjList.put(pre, lst);

            indegree[pos] += 1;
        }
        //Creating the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topologicalOrder[i++] = node;
            if(adjList.containsKey(node)){
                for(Integer neighbour : adjList.get(node)){
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0)
                        q.add(neighbour);
                }
            }
        }
        if(i == numCourses)
            return topologicalOrder;
        return 
            new int[0];
    }
}