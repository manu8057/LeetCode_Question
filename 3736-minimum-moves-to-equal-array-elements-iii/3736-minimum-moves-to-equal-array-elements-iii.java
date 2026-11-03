class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int max=nums[0];
        int n=nums.length;
        for(int i:nums){
            sum+=i;
            max=Math.max(i,max);
        }
        return max*n-sum;
    }
}