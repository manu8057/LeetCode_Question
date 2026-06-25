class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int c=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            int y=0;
            for(int j=i;j<n;j++){
                y++;
                if(nums[j]==target){
                    count++;
                }
                if(count>y/2){
                    c++;
                }
            }
        }
        return c;
    }
}