class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=(int)1e9+7;
        int n=nums.length;
        for(int ar[]:queries){
            int l=ar[0];
            int r=ar[1];
            int k=ar[2];
            int v=ar[3];
            while(l<=r){
               long tem=nums[l];
               tem=(tem*v)%mod;
               nums[l]=(int)tem;
               l+=k;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans^=nums[i];
        }
        return ans;
    }
}