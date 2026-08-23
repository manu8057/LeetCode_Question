class Solution {
     public void fun(int r,int c,int n,int m,int tem,int cl,int grid[][]){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]!=tem || grid[r][c]==cl){
            return;
        }
        grid[r][c]=cl;
        fun(r+1,c,n,m,tem,cl,grid);
        fun(r-1,c,n,m,tem,cl,grid);
        fun(r,c+1,n,m,tem,cl,grid);
        fun(r,c-1,n,m,tem,cl,grid);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        fun(sr,sc,n,m,image[sr][sc],color,image);
        return image;
    }
}