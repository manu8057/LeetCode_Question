class Solution {
    public boolean fun(int r,int c,int n,int m,int grid[][],boolean vis[][]){
        if(r<0 || c<0 || r>=n || c>=m || vis[r][c]){
            return false;
        }
        if(r==n-1 && c==m-1){
            return true;
        }
        vis[r][c]=true;
        int el=grid[r][c];
        if(el==1){
            if(c+1<m && (grid[r][c+1]==1 || grid[r][c+1]==3 || grid[r][c+1]==5)){
                if(fun(r,c+1,n,m,grid,vis)){
                    return true;
                }
            }
            if(c-1>=0 && (grid[r][c-1]==1 || grid[r][c-1]==4 || grid[r][c-1]==6)){
                if(fun(r,c-1,n,m,grid,vis)){
                    return true;
                }
            }
        }
        else if(el==2){
            if(r+1<n && (grid[r+1][c]==2 || grid[r+1][c]==5 || grid[r+1][c]==6)){
                if(fun(r+1,c,n,m,grid,vis)){
                    return true;
                }
            }
            if(r-1>=0 && (grid[r-1][c]==2 || grid[r-1][c]==3 || grid[r-1][c]==4)){
                if(fun(r-1,c,n,m,grid,vis)){
                    return true;
                }
            }
        }
        else if(el==3){
            if(c-1>=0 && (grid[r][c-1]==1 || grid[r][c-1]==4 || grid[r][c-1]==6)){
                if(fun(r,c-1,n,m,grid,vis)){
                    return true;
                }
            }
            if(r+1<n && (grid[r+1][c]==2 || grid[r+1][c]==5 || grid[r+1][c]==6)){
                if(fun(r+1,c,n,m,grid,vis)){
                    return true;
                }
            }
        }
        else if(el==4){
            if(c+1<m && (grid[r][c+1]==1 || grid[r][c+1]==3 || grid[r][c+1]==5)){
                if(fun(r,c+1,n,m,grid,vis)){
                    return true;
                }
            }
            if(r+1<n && (grid[r+1][c]==2 || grid[r+1][c]==5 || grid[r+1][c]==6)){
                if(fun(r+1,c,n,m,grid,vis)){
                    return true;
                }
            }
        }
        else if(el==5){
            if(c-1>=0 && (grid[r][c-1]==1 || grid[r][c-1]==4 || grid[r][c-1]==6)){
                if(fun(r,c-1,n,m,grid,vis)){
                    return true;
                }
            }
            if(r-1>=0 && (grid[r-1][c]==2 || grid[r-1][c]==3 || grid[r-1][c]==4)){
                if(fun(r-1,c,n,m,grid,vis)){
                    return true;
                }
            }
        }
        else{
            if(c+1<m && (grid[r][c+1]==1 || grid[r][c+1]==3 || grid[r][c+1]==5)){
                if(fun(r,c+1,n,m,grid,vis)){
                    return true;
                }
            }
            if(r-1>=0 && (grid[r-1][c]==2 || grid[r-1][c]==3 || grid[r-1][c]==4)){
                if(fun(r-1,c,n,m,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        return fun(0,0,n,m,grid,vis);
    }
}