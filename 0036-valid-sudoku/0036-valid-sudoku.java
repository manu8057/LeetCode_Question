class Solution {
    public boolean check(char arr[][],int r,int c){
        char ch=arr[r][c];
        for(int i=0;i<9;i++){
            if(i!=r && arr[i][c]==ch){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(i!=c && arr[r][i]==ch){
                return false;
            }
        }
        int sr=(r/3)*3;
        int sc=(c/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if((i!=r || j!=c) && arr[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!check(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}