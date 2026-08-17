class Solution {
    public int stoneGameV(int[] a) {
        int n=a.length;
        long[] p=new long[n+1];
        for(int i=0;i<n;i++) p[i+1]=p[i]+a[i];
        int[][] d=new int[n][n];
        int[][] lb=new int[n][n];
        int[][] rb=new int[n][n];
        int[] lp=new int[n];
        int[] rp=new int[n];
        for(int i=0;i<n;i++){
            lb[i][i]=a[i];
            rb[i][i]=a[i];
            lp[i]=i-1;
            rp[i]=i;
        }
        for(int z=2;z<=n;z++){
            for(int l=0;l+z<=n;l++){
                int r=l+z-1;
                long t=p[r+1]-p[l];
                while(lp[l]+1<=r-1){
                    int k=lp[l]+1;
                    long s=p[k+1]-p[l];
                    if(2*s>t) break;
                    lp[l]++;
                }
                while(rp[l]<=r-1){
                    int k=rp[l];
                    long s=p[k+1]-p[l];
                    if(2*s>=t) break;
                    rp[l]++;
                }
                int b=0;
                if(lp[l]>=l) b=lb[l][lp[l]];
                if(rp[l]<=r-1) b=Math.max(b,rb[rp[l]+1][r]);

                d[l][r]=b;
                lb[l][r]=Math.max(lb[l][r-1],d[l][r]+(int)t);
                rb[l][r]=Math.max(rb[l+1][r],d[l][r]+(int)t);
            }
        }
        return d[0][n-1];
    }
}