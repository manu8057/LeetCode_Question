class Solution {
    public int networkDelayTime(int[][] times, int n, int s) {
        int mat[][]=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i!=j){
                    mat[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int ar[]:times){
            mat[ar[0]][ar[1]]=ar[2];
        }
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(mat[i][k]==Integer.MAX_VALUE || mat[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        int max=0;
        for(int j=1;j<=n;j+=1){
            if(mat[s][j]==Integer.MAX_VALUE) return -1;
            if(mat[s][j]>max){
                max=mat[s][j];
            }
        }
        return max;
    }
}