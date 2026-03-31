class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int ans[]=new int[queries.length];
        int sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                sum+=nums[i];
            }
        }
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            if(nums[b]%2==0){
                sum-=nums[b];
            }
            nums[b]+=a;
            if(nums[b]%2==0){
                sum+=nums[b];
            }
            ans[i]=sum;
        }
        return ans;
    }
}