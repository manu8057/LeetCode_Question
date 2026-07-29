class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int arr1[]=new int[n];
        int arr2[]=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            int max2=0;
            for(int j=0;j<n;j+=1){
                max=Math.max(max,grid[i][j]);
                max2=Math.max(max2,grid[j][i]);
            }
            arr1[i]=max;
            arr2[i]=max2;
        }
        int ans=0;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                ans+=Math.min(arr1[i],arr2[j])-grid[i][j];
            }
        }
        return ans;
    }
}