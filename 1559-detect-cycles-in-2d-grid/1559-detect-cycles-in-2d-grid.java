class Solution {
    public boolean fun(int r,int c,int pr,int pc,int n,int m,char grid[][],boolean vis[][]){
        vis[r][c]=true;
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==grid[r][c]){
                if(!vis[nr][nc]){
                    if(fun(nr,nc,r,c,n,m,grid,vis)) return true;
                }
                else if(nr!=pr || nc!=pc){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(fun(i,j,-1,-1,n,m,grid,vis)) return true;
                }
            }
        }
        return false;
    }
}