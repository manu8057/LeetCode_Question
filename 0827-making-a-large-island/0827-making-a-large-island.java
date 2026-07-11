class Solution {
    HashMap<Integer,Integer>map=new HashMap<>();
    public int fun(int r,int c,int n,int grid[][],int id){
        if(r<0 || c<0 || r>=n || c>=n || grid[r][c]!=1){
            return 0;
        }
        grid[r][c]=id;
        return 1+fun(r+1,c,n,grid,id)+fun(r,c+1,n,grid,id)+fun(r-1,c,n,grid,id)+fun(r,c-1,n,grid,id);
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int id=2;
        int y=0;
        int m=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int a=fun(i,j,n,grid,id);
                    map.put(id,a);
                    id++;
                    m=Math.max(a,m);
                }
                if(grid[i][j]==0){
                    y++;
                }
            }
        }
        if(y==0){
            return m;
        }
        if(id==2){
            return 1;
        }
        if(id==3 && y!=0){
            return m+1;
        }
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int sum=1;
                    HashSet<Integer>set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int r=dr[k]+i;
                        int c=dc[k]+j;
                        if(r>=0 && c>=0 && r<n && c<n && grid[r][c]!=0 && !set.contains(grid[r][c])){
                            set.add(grid[r][c]);
                            sum+=map.get(grid[r][c]);
                        }
                    }
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }
}