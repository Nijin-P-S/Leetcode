//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static void findAllPossible(int a[], int N, ArrayList<String> ans, int ind, String cur,  HashMap<Integer, List<Character>> mapping){
        if(ind == N){
            ans.add(cur);
            return;
        }
        List<Character> chars = mapping.get(a[ind]);
        
        for(Character c : chars){
            findAllPossible(a, N, ans, ind+1, cur+""+c, mapping);
        }
    }
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        HashMap<Integer, List<Character>> mapping = new HashMap<>();
        mapping.put(2, Arrays.asList('a','b', 'c'));
        mapping.put(3, Arrays.asList('d','e', 'f'));
        mapping.put(4, Arrays.asList('g','h', 'i'));
        mapping.put(5, Arrays.asList('j','k', 'l'));
        mapping.put(6, Arrays.asList('m','n', 'o'));
        mapping.put(7, Arrays.asList('p','q', 'r','s'));
        mapping.put(8, Arrays.asList('t','u', 'v'));
        mapping.put(9, Arrays.asList('w','x', 'y', 'z'));
        
        ArrayList<String> ans = new ArrayList<>();
        findAllPossible(a, N, ans, 0, "", mapping);
        return ans;
    }
}


