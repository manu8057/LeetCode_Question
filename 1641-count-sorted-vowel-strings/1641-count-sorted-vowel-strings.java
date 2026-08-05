class Solution {
    Integer dp[][];
    public int fun(int id,int c,int n){
        if(id>=5 || c==n){
            if(c==n) return  1;
            return 0;
        }
        if(dp[id][c]!=null) return dp[id][c];
        return dp[id][c]=fun(id,c+1,n) + fun(id+1,c,n);
    }
    public int countVowelStrings(int n){
        dp=new Integer[6][n+1];
        return fun(0,0,n);
    }
}