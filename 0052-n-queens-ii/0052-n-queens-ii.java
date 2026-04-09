class Solution {
    public boolean check(int r,int c,int n,int arr[][]){
        for(int i=0;i<n;i++){
            if(arr[i][c]==1){
                return false;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[r][i]==1){
                return false;
            }
        }
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(arr[i][j]==1){
                return false;
            }
            i--;
            j--;
        }
        i=r;
        j=c;
        while(i>=0 && j<n){
            if(arr[i][j]==1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    public int fun(int id,int n,int arr[][]){
        if(id==n){
            return 1;
        }
        int a=0;
        for(int i=0;i<n;i++){
            if(check(id,i,n,arr)){
                arr[id][i]=1;
                a+=fun(id+1,n,arr);
                arr[id][i]=0;
            }
        }
        return a;
    }
    public int totalNQueens(int n) {
        int arr[][]=new int[n][n];
        return fun(0,n,arr);
    }
}