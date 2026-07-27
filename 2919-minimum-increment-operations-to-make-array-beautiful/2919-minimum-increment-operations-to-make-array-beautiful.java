class Solution {
    public int find(int s,int en,int nums[],int k){
        int max=0;
        for(int i=s;i<=en;i+=1){
            max=Math.max(nums[i],max);
        }
        if(max<k){
             for(int i=s;i<=en;i+=1){
                nums[i]=nums[i]+k-max;
             }
        }
        return max;
    }
    public long minIncrementOperations(int[] nums, int k) {
        long ans=0;
        int n=nums.length;
        int max=0;
        int o=find(0,2,nums,k);
        if(o<k){
            ans=ans+k-o;
        }
        for(int i=3;i<n;i++){
            int a=find(i-2,i,nums,k);
            if(a<k){
                ans=ans+k-a;
            }
        }
        return ans;
    }
}