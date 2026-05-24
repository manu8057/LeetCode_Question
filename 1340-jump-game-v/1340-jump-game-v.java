class Solution {
    int n;
    int solve(int i,int arr[],int d,int dp[]) {
        if(dp[i]!=-1) {
            return dp[i];
        }
        int max=1;
        for(int j=i+1;j<=Math.min(n-1,i+d);j++) {
            if(arr[j]>=arr[i]){
                break;
            }
            max=Math.max(max,1+solve(j,arr,d,dp));
        }
        for(int j=i-1;j>=Math.max(0,i-d);j--) {
            if(arr[j]>=arr[i]) {
                break;
            }
            max=Math.max(max,1+solve(j,arr,d,dp));
        }
        return dp[i]=max;
    }
    public int maxJumps(int[] arr,int d) {
        n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int ans=1;
        for(int i=0;i<n;i++) {
            ans=Math.max(ans,solve(i,arr,d,dp));
        }
        return ans;
    }
}