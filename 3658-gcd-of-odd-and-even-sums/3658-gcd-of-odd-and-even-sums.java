class Solution {
    public int fun(int a,int b){
        while(b!=0){
            int tem=b;
            b=a%b;
            a=tem;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int odd=n*n;
        int even=n*(n+1);
        return fun(odd,even);
    }
}