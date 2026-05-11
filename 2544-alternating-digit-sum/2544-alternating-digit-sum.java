class Solution {
    public int alternateDigitSum(int n) {
        int sum1=0;
        int sum2=0;
        boolean fl=false;
        while(n>0){
            if(!fl){
                sum2+=n%10;
                fl=!fl;
            }
            else{
                sum1+=n%10;
                fl=!fl;
            }
            n=n/10;
        }
        if(fl) return sum2-sum1;
        else return sum1-sum2;
    }
}