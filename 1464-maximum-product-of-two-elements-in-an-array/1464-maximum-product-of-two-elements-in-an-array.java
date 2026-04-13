class Solution {
    public int maxProduct(int[] nums) {
       int pre=0;
       int max=0;
       for(int i=0;i<nums.length;i++){
            if(nums[i]>=max){
                pre=max;
                max=nums[i];
            }
            else{
                if(nums[i]>pre){
                    pre=nums[i];
                }
            }
       }
       return (max-1)*(pre-1);
    }
}