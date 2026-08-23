class Solution {
    public void fun(int r,int c,int n,int m,char board[][]){
        if(r<0 || c<0 || r>=n || c>=m || board[r][c]!='O'){
            return;
        }
        board[r][c]='m';
        fun(r+1,c,n,m,board);
        fun(r,c+1,n,m,board);
        fun(r-1,c,n,m,board);
        fun(r,c-1,n,m,board);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<m;i+=1){
            if(board[0][i]=='O'){
                fun(0,i,n,m,board);
            }
        }
        for(int i=0;i<m;i+=1){
            if(board[n-1][i]=='O'){
                fun(n-1,i,n,m,board);
            }
        }
        for(int i=0;i<n;i+=1){
            if(board[i][0]=='O'){
                fun(i,0,n,m,board);
            }
        }
        for(int i=0;i<n;i+=1){
            if(board[i][m-1]=='O'){
                fun(i,m-1,n,m,board);
            }
        }
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(board[i][j]=='m'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
}