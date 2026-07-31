class Solution {
    public int findTheCity(int n, int[][] edges, int d) {
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                if(i==j){
                    mat[i][j]=0;
                }
                else{
                    mat[i][j]=100000;
                }
            }
        }
        for(int ar[]:edges){
            mat[ar[0]][ar[1]]=ar[2];
            mat[ar[1]][ar[0]]=ar[2];
        }
        for(int k=0;k<n;k+=1){
            for(int i=0;i<n;i+=1){
                for(int j=0;j<n;j+=1){
                    if(mat[i][k]==10000 || mat[k][j]==10000){
                        continue;
                    }
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        int ans=0;
        int mn=n+1;
        for(int i=0;i<n;i+=1){
            int c=0;
            for(int j=0;j<n;j+=1){
                if(i!=j && mat[i][j]<=d){
                    c++;
                }
            }
            if(c<=mn){
                ans=i;
                mn=c;
            }    
        }
        return ans;
    }
}