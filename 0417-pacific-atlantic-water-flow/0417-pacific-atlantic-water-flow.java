class Solution {
    public void fun(int r,int c,int n,int m,int grid[][],int arr[][],int pre){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]<pre || arr[r][c]==1){
            return;
        }
        arr[r][c]=1;
        fun(r+1,c,n,m,grid,arr,grid[r][c]);
        fun(r,c+1,n,m,grid,arr,grid[r][c]);
        fun(r-1,c,n,m,grid,arr,grid[r][c]);
        fun(r,c-1,n,m,grid,arr,grid[r][c]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int arr1[][]=new int[n][m];
        int arr2[][]=new int[n][m];
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<m;i+=1){
            fun(0,i,n,m,heights,arr1,Integer.MIN_VALUE);
            fun(n-1,i,n,m,heights,arr2,Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i+=1){
            fun(i,0,n,m,heights,arr1,Integer.MIN_VALUE);
            fun(i,m-1,n,m,heights,arr2,Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(arr1[i][j]==1 && arr2[i][j]==1){
                    List<Integer>l=new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    res.add(l);
                }
            }
        }
        return res;
    }
}