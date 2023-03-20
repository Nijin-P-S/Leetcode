class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 1)
            return 0;
        int left = 0, right = arr.length-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(arr[mid] > arr[mid+1])
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }
}