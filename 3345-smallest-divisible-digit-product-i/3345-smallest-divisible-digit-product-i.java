class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int y=n;
            int f=1;
            while(y>0){
                f*=y%10;
                y/=10;
            }
            if(f%t==0){
                return n;
            }
            n=n+1;
        }
    }
}