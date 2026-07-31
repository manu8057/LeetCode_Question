class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int max=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            max=Math.min(nums[i]-nums[i-1],max);
        }
        return max;
    }
}