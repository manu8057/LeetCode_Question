class Solution {
    static final long MOD=1000000007L;
    long pow(long b,long e) {
        long r=1;
        while(e>0) {
            if((e&1L)!=0) r=r*b%MOD;
            b=b*b%MOD;
            e>>=1;
        }
        return r;
    }
    public int numberOfSets(int n,int k) {
        long N=n+k-1L;
        long R=2L*k;
        R=Math.min(R,N-R);
        long num=1,den=1;
        for(long i=1;i<=R;i++) {
            num=num*(N-R+i)%MOD;
            den=den*i%MOD;
        }
        long inv=pow(den,MOD-2);
        return (int)(num*inv%MOD);
    }
}