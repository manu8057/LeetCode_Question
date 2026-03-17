class Solution {
    int dp[][];
    public int fun(String s,StringBuilder sb,int n,int id1,int id2){
        if(id1==n || id2==n){
            return 0;
        }
        if(dp[id1][id2]!=-1){
            return dp[id1][id2];
        }
        if(s.charAt(id1)==sb.charAt(id2)){
            return dp[id1][id2]=1+fun(s,sb,n,id1+1,id2+1);
        }
        else{
            return dp[id1][id2]=Math.max(fun(s,sb,n,id1+1,id2),fun(s,sb,n,id1,id2+1));
        }
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        return fun(s,sb,n,0,0);
    }
}