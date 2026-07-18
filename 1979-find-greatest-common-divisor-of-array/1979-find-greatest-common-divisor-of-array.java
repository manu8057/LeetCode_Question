class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int tem=b;
            b=a%b;
            a=tem;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int max=-1;
        int min=1001;
        for(int el:nums){
            max=Math.max(max,el);
            min=Math.min(min,el);
        }
        return gcd(max,min);
    }
}