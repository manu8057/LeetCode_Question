class Solution {
    public int maxProduct(int n) {
        int t=n;
        int pre=-1;
        int max=-1;
        while(t>0){
            int m=t%10;
            if(m>=max){
                pre=max;
                max=m;
            }
            else if(m>=pre){
                pre=m;
            }
            t/=10;
        }
        return pre*max;
    }
}