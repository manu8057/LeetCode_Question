class Solution {
    Integer dp[][];
    public int fun(int id1,int id2,int n1,int n2,String s,String t){
        if(id1==n1 || id2==n2){
            if(id2==n2){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[id1][id2]!=null){
            return dp[id1][id2];
        }
        int a=0;
        int b=0;
        if(s.charAt(id1)==t.charAt(id2)){
            a=fun(id1+1,id2+1,n1,n2,s,t);
        }
        b=fun(id1+1,id2,n1,n2,s,t);
        return dp[id1][id2]=a+b;
    }
    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        dp=new Integer[n1+1][n2+1];
        return fun(0,0,n1,n2,s,t);
    }
}