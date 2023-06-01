class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Double> unique = new HashSet<>();
        
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left <= right){
            int first = nums[left++];
            int second = nums[right--];
            unique.add((first+second)/2.0);
        }
        
        return unique.size();
    }
}