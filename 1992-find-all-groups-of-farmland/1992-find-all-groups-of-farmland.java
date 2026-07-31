class Solution {
    int x1=0;
    int y1=0;
    public void fun(int r,int c,int arr[][],int n,int m){
        if(r<0 || c<0 || r>=n || c>=m || arr[r][c]==0){
            return;
        }
        if(r+c>x1+y1){
            x1=r;
            y1=c;
        }
        arr[r][c]=0;
        fun(r+1,c,arr,n,m);
        fun(r,c-1,arr,n,m);
        fun(r-1,c,arr,n,m);
        fun(r,c+1,arr,n,m);

    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        int n=land.length;
        int m=land[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1){
                    ArrayList<Integer>l=new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    x1=i;
                    y1=j;
                    fun(i,j,land,n,m);
                    l.add(x1);
                    l.add(y1);
                    res.add(new ArrayList<>(l));
                }
            }
        }
        int mat[][]=new int[res.size()][4];
        int id=0;
        for(ArrayList<Integer>list:res){
            mat[id][0]=list.get(0);
            mat[id][1]=list.get(1);
            mat[id][2]=list.get(2);
            mat[id][3]=list.get(3);
            id++;
        }
        return mat;
    }
}