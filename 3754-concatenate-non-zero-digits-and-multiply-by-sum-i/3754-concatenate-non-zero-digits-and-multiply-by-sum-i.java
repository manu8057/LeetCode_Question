class Solution {
    public long sumAndMultiply(int n) {
        long a=0;
        long sum=0;
        while(n>0){
            sum+=(n%10);
            if(n%10!=0) a=a*10+(n%10);
            n/=10;
        }
        long ans=0;
        while(a>0){
            ans=ans*10+(a%10);
            a/=10;
        }
        return ans*sum;
    }
}