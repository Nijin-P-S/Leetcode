class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> gr = new HashMap<>();
        
        Stack<Integer> cur = new Stack<>();
        
        for(int i=nums2.length-1; i>=0; i--){
            while(!cur.isEmpty() && cur.peek() <= nums2[i]){
                cur.pop();
            }
            if(cur.isEmpty()){
                gr.put(nums2[i], -1);
                cur.push(nums2[i]);
            }
            else{
                gr.put(nums2[i], cur.peek());
                cur.push(nums2[i]);
            }
        }
        
        int[] ans = new int[nums1.length];
        
        for(int i=0; i<nums1.length; i++){
            ans[i] = gr.get(nums1[i]);
        }
        return ans;
    }
}