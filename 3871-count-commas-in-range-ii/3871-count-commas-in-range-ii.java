class Solution {
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }
        long t=n;
        long len=0;
        while(t>0){
            t=t/10;
            len++;
        }
        if(len<=6){
            return n-999;
        }
        else if(len<=9){
            return (long)((n-999999L)+n-999);
        }
        else if(len<=12){
            return (long)(n-999999999L)+(n-999999)+n-999;
        }
        else if(len<=15){
            return (long)(n-999999999999L)+(n-999999999L)+(n-999999L)+n-999;
        }
        else{
            return (long)(n-999999999999999L)+(n-999999999999L)+(n-999999999L)+(n-999999L)+n-999;
        }
    }
}