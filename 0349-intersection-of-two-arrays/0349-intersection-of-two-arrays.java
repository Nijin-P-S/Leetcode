class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0, p2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                if(!ans.isEmpty() && ans.get(ans.size()-1) == nums1[p1]){
                    p1++;
                    p2++;
                    continue;
                }
                
                ans.add(nums1[p1]);
                p1++;
                p2++;
            } 
            else if(nums1[p1] > nums2[p2])
                p2++;
            else
                p1++;
        }
        
        int[] out = new int[ans.size()];
        int i = 0;
        for(int val : ans)
            out[i++] = val;
        return out;
    }
}