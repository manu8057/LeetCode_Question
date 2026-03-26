class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=(long)grid[i][j];
            }
        }
        if(sum%2!=0){
            return false;
        }
        long sm=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sm+=(long)grid[i][j];
            }
            if(sm==sum/2){
                return true;
            }
        }
        sm=0;
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                sm+=(long)grid[i][j];
            }
            if(sm==sum/2){
                return true;
            }
        }
        return false;
    }
}