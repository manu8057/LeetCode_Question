class Solution {
    public int maxDistance(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]!=nums[i]){
                    max=Math.max(j-i,max);
                }
            }
        }
        return max;
    }
}