class Solution {
    HashMap<String,Integer>map=new HashMap<>();
    public int fun(int n,int id,int f){
        if(n==0){
            if(f==1){
                return 1;
            }
            return 0;
        }
        if(id==0) return 0;
        // if(map.contains())
        int a=1;
        int b=1;
        a=Math.max(a,fun(n,id-1,f));
        if(n-id>=0){
            a=Math.max(a,id*Math.max(fun(n-id,id,1),fun(n-id,id-1,1)));
        }
        return a;
    }
    public int integerBreak(int n) {
        return fun(n,n-1,0);
    }
}