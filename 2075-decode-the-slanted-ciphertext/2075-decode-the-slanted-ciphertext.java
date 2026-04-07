class Solution {
    public String decodeCiphertext(String ed, int rows) {
        int n=ed.length();
        if(n==0){
            return "";
        }
        int c=n/rows;
        char mat[][]=new char[rows][c];
        int id=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<c;j++){
                mat[i][j]=ed.charAt(id);
                id++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<c;i++){
            int r=0;
            int col=i;
            while(r<rows && col<c){
                sb.append(mat[r][col]);
                r+=1;
                col+=1;
            }
        }
        int len=sb.length()-1;
        while(sb.charAt(len)==' '){
            len--;
        }
        return sb.substring(0,len+1).toString();
    }
}