class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long l[][]=new long[n][m];
        long r[][]=new long[n][m];
        long p=1;
        long mod=12345;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                l[i][j]=p;
                p=(p*(long)grid[i][j])%mod;
            }
        }
        p=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                r[i][j]=p;
                p=(p*(long)grid[i][j])%mod;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=(int)((l[i][j]*r[i][j])%mod);
            }
        }
        return grid;
    }
}