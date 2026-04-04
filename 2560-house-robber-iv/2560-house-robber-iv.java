class Solution {
    public boolean fun(int nums[],int lm,int k){
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=lm){
                c++;
                i++;
            }
        }
        return c>=k;
    }
    public int minCapability(int[] nums, int k) {
        int l=0;
        int ed=0;
        int n=nums.length;
        for(int x:nums){
            if(x>ed){
                ed=x;
            }
        }
        int ans=0;
        while(l<=ed){
            int mid=(l+ed)/2;
            if(fun(nums,mid,k)){
                ans=mid;
                ed=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}