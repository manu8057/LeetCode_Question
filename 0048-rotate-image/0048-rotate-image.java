class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int arr[]=new int[n*m];
        int id=0;
        for(int j=0;j<m;j++){
            for(int i=n-1;i>=0;i--){
                arr[id]=matrix[i][j];
                id++;
            }
        }
        id=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=arr[id];
                id++;
            }
        }
    }
}