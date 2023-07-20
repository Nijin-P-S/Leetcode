class NumArray {

    int[] num;
    int[] sum;
    public NumArray(int[] nums) {
        this.num = new int[nums.length];
        this.sum = new int[nums.length];
        
        for(int i=0; i<num.length; i++){
            this.num[i] = nums[i];
            if(i == 0)
                sum[i] = nums[i];
            else
                sum[i] = nums[i]+sum[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0 && right == num.length-1)
            return sum[right];
        else if(left == 0)
            return sum[right];
        else
            return sum[right] - sum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */