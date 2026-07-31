class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                boolean f=false;
                for(int k=0;k<4;k+=1){
                    int r=dr[k]+i;
                    int c=dc[k]+j;
                    if(r>=0 && r<n && c<m && c>=0){
                        if(mat[r][c]>=mat[i][j]){
                           f=true;
                           break;
                        }
                    }
                }
                if(!f) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}