class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=grid[i][j];
            }
        }
        int r=x;
        for(int i=x+k-1;i>=x;i--){
            int c=y;
            for(int j=y;j<y+k;j++){
                ans[r][c]=grid[i][j];
                c++;
            }
            r+=1;
        }
        return ans;
    }
}