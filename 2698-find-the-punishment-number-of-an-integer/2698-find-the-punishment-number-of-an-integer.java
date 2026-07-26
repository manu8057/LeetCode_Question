class Solution {
    public boolean fun(int sq,int d){
       if(sq==0) return d==0;
       if(sq<0 || d<0) return false;
       if(sq==d) return true;
       return (fun(sq/10,d-(sq%10)) || fun(sq/100,d-(sq%100)) || fun(sq/1000,d-(sq%1000)));
    }
    public int punishmentNumber(int n) {
        int i=1;
        int ans=0;
        while(i<=n){
            int m=i*i;
            if(fun(m,i)){
                ans+=m;
            }
            i+=1;
        }
        return ans;
    }
}