class Solution {
    Long dp[][];
    public long fun(int id,int turn,int nums[],int x,int n){
        if(id==n){
            return 0;
        }
        if(dp[id][turn]!=null){
            return dp[id][turn];
        }
        long a=0;
        long b=0;
        if(turn==0){
            long a1=0;
            long b1=0;
            if(nums[id]%2==0){
                a1=(long)nums[id]+fun(id+1,0,nums,x,n);
            }
            else{
                b1=Math.max((long)nums[id]-(long)x+fun(id+1,1,nums,x,n),fun(id+1,0,nums,x,n));
            }
            a=Math.max(a1,b1);
        }
        else{
            long a1=0;
            long b1=0;
            if(nums[id]%2==1){
                a1=(long)nums[id]+fun(id+1,1,nums,x,n);
            }
            else{
                b1=Math.max((long)nums[id]-(long)x+fun(id+1,0,nums,x,n),fun(id+1,1,nums,x,n));
            }
            b=Math.max(a1,b1);
        }
        return dp[id][turn]=Math.max(a,b);
    }
    public long maxScore(int[] nums, int x) {
        int n=nums.length;
        dp=new Long[n+1][2];
        int y=0;
        if(nums[0]%2==1){
            y=1;
        }
        return fun(0,y,nums,x,n);
    }
}