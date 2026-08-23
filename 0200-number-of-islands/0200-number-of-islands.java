class Solution {
    public void fun(int r,int c,int n,int m,char grid[][]){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]!='1'){
            return;
        }
        grid[r][c]=0;
        fun(r+1,c,n,m,grid);
        fun(r-1,c,n,m,grid);
        fun(r,c+1,n,m,grid);
        fun(r,c-1,n,m,grid);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(grid[i][j]=='1'){
                    fun(i,j,n,m,grid);
                    ans+=1;
                }
            }
        }
        return ans;
    }
}