class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        
        HashSet<Integer> num1Unique = new HashSet<>();
        HashSet<Integer> num2Unique = new HashSet<>();
        for(int num : nums1){
            num1Unique.add(num);
        }
        for(int num : nums2){
            num2Unique.add(num);
        }
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        for(int val : num1Unique){
            if(!num2Unique.contains(val))
                num1.add(val);
        }
        for(int val : num2Unique){
            if(!num1Unique.contains(val))
                num2.add(val);
        }
        
        ans.add(num1);
        ans.add(num2);
        
        return ans;
    }
}