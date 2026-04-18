class Solution {
    public int rev(int n){
        int ans=0;
        while(n>0){
            int m=n%10;
            ans=ans*10+m;
            n/=10;
        }
        return ans;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n-rev(n));
    }
}