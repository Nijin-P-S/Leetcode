//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution
{
    public int[][] overlappedInterval(int[][] intervals)
    {
        // Code here // Code here
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
    
        for(int i=0; i<intervals.length; i++){
            int[] cur = intervals[i];
            if(!stack.isEmpty() && stack.peek()[1] >= cur[0]){
                int[] top = stack.pop();
                top[1] = Math.max(top[1], cur[1]);
                stack.push(top);
            }
            else{
                stack.push(cur);
            }
        }
        
        int[][] ans = new int[stack.size()][2];
        int ind = stack.size()-1;
        
        while(!stack.isEmpty()){
            ans[ind][0] = stack.peek()[0];
            ans[ind][1] = stack.peek()[1];
            stack.pop();
            ind--;
        }
        return ans;
    }
}