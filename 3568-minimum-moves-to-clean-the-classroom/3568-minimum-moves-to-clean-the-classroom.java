class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n=classroom.length;
        int m=classroom[0].length();
        int arr[][]=new int[n][m];
        int r=0;
        int c=0;
        int lt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=classroom[i].charAt(j);
                if(ch=='S'){
                    r=i;
                    c=j;
                }
                if(ch=='L'){
                    arr[i][j]=lt;
                    lt++;
                }
            }
        }
        if(lt==0) return 0;
        int target=(1<<lt)-1;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{r,c,energy,0,0});
        boolean vis[][][][]=new boolean[n][m][energy+1][1<<lt];
        vis[r][c][energy][0]=true;
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        while(!q.isEmpty()){
            int ar[]=q.poll();
            int cr=ar[0];
            int cc=ar[1];
            int en=ar[2];
            int mask=ar[3];
            int steps=ar[4];
            for(int k=0;k<4;k++){
                int nr=cr+dr[k];
                int nc=cc+dc[k];
                if(nr>=0 && nc>=0 && nr<n && nc<m && classroom[nr].charAt(nc)!='X'){
                    int nen=en-1;
                    int nmask=mask;
                    char ch=classroom[nr].charAt(nc);
                    if(ch=='L'){
                        nmask|=(1<<arr[nr][nc]);
                    }
                    if(nmask==target){
                        return steps+1;
                    }
                    if(ch=='R'){
                        nen=energy;
                    }
                    if(nen==0 && ch!='R'){
                        continue;
                    }
                    if(!vis[nr][nc][nen][nmask]){
                        vis[nr][nc][nen][nmask]=true;
                        q.add(new int[]{nr,nc,nen,nmask,steps+1});
                    }
                }
            }
        }
        return -1;
    }
}