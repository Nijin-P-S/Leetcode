class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  
        for(int i=0; i<nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length; j++){
                if(j != i+1 && nums[j] == nums[j-1])
                    continue;
                int left = j+1, right = nums.length-1;
                while(left < right){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right];
                    if(sum == target){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        ans.add(cur);
                        left++;
                        right--;
                        while(left < nums.length && nums[left] == nums[left-1])
                            left++;
                        while(right >= 0 && nums[right] == nums[right+1])
                            right--;
                    }
                    else if(sum > target)
                        right--;
                    else
                        left++;
                }
            }
        }
        return ans;
    }
}