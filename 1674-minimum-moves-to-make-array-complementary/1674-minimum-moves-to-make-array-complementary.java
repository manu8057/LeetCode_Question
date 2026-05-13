class Solution{
    public int minMoves(int[] nums,int limit){
        int n=nums.length;
        int diff[]=new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int a=nums[i];
            int b=nums[n-i-1];
            int mn=Math.min(a,b);
            int mx=Math.max(a,b);
            diff[mn+1]--;
            diff[mx+limit+1]++;
            diff[mn+mx]--;
            diff[mn+mx+1]++;
        }
        int cur=(n/2)*2;
        int ans=Integer.MAX_VALUE;
        for(int i=2;i<=2*limit;i++){
            cur+=diff[i];
            ans=Math.min(ans,cur);
        }
        return ans;
    }
}