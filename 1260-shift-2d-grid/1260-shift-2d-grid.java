class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid,int k) {
        List<List<Integer>> l=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        k%=(n*m);
        int arr[][]=new int[n][m];
        int r=(n*m-k)/m;
        int c=(n*m-k)%m;
        int i=0;
        int j=0;
        for(int s=r;s<n;s++){
            int start=(s==r)?c:0;
            for(int t=start;t<m;t++){
                arr[i][j]=grid[s][t];
                j++;
                if(j==m){
                    j=0;
                    i++;
                }
            }
        }
        for(int s=0;s<=r;s++){
            int end=(s==r)?c:m;
            for(int t=0;t<end;t++){
                arr[i][j]=grid[s][t];
                j++;
                if(j==m){
                    j=0;
                    i++;
                }
            }
        }
        for(i=0;i<n;i++){
            l.add(new ArrayList<>());
            for(j=0;j<m;j++){
                l.get(i).add(arr[i][j]);
            }
        }
        return l;
    }
}