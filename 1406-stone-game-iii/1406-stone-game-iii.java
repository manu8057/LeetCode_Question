class Solution {
    Integer dp[][];
    public int fun(int id,int n,int arr[],int t){
        if(id>=n){
            return 0;
        }
        if(dp[id][t]!=null) return dp[id][t];
        if(t==0){
            int sum=0;
            int a=Integer.MIN_VALUE;
            for(int i=id;i<id+3 && i<n;i+=1){
                sum+=arr[i];
                a=Math.max(a,sum+fun(i+1,n,arr,1));
            }
            return dp[id][t]=a;
        }
        else{
            int sum=0;
            int b=Integer.MAX_VALUE;
            for(int i=id;i<id+3 && i<n;i+=1){
                sum+=arr[i];
                b=Math.min(b,-sum+fun(i+1,n,arr,0));
            }
            return dp[id][t]=b;
        }
    }
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new Integer[n][2];
        int a=fun(0,n,stoneValue,0);
        if(a>0) return "Alice";
        if(a<0) return "Bob";
        return "Tie";
    }
}