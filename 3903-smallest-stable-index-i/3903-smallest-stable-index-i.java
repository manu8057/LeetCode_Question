class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        // int fr[]=new int[101];
        // for(int el:nums){
        //    fr[el]++;
        // }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            int min=nums[i];
            for(int j=i;j<n;j++){
                min=Math.min(min,nums[j]);
            }
            if(max-min<=k){
                return i;
            }
        }
        return -1;
    }
}